package org.springframework.social.digg.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.digg.api.ActivityType;
import org.springframework.social.digg.api.DiggUser;
import org.springframework.social.digg.api.StoriesResponse;
import org.springframework.social.digg.api.Story;
import org.springframework.social.digg.api.UserFollowResponse;
import org.springframework.social.digg.api.UserGetInfoResponse;
import org.springframework.social.digg.api.UserOperations;
import org.springframework.social.digg.api.UserUnfollowResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class UserTemplate extends AbstractDiggOperations implements UserOperations {
	
	private static final Logger logger = LoggerFactory.getLogger(UserTemplate.class);

	private final RestTemplate restTemplate;

	public UserTemplate(final RestTemplate restTemplate, final boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
//		
//		final ResponseErrorHandler handler = new ResponseErrorHandler() {
//
//			@Override
//			public boolean hasError(final ClientHttpResponse response)
//					throws IOException {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public void handleError(final ClientHttpResponse response)
//					throws IOException {
//				// TODO Auto-generated method stub
//				
//			} };
//			
//		this.restTemplate.setErrorHandler(handler);
	}
	
	private List<DiggUser> getUserListByField(final String field, final String key, final List<String> values) {
		final StringBuilder sb = new StringBuilder();
		
		for (final String value: values) {
			if (value == null) {
				throw new IllegalArgumentException("value cannot be null");
			}
			
			if (value.length() < 1) {
				throw new IllegalArgumentException("value cannot be empty");
			}
			
			if (sb.length() > 0) {
				sb.append(',');
			}
			
			sb.append(value);
		}
		
		final String valueList = sb.toString();
		
		final UserGetInfoResponse response = restTemplate.getForObject(buildUri("user.getInfo", key, valueList), UserGetInfoResponse.class);
		
		if (response == null) {
			return null;
		}
		
//		if (logger.isDebugEnabled()) {
			logger.warn(response.toString());
//		}
		
		if (response.getUsers() == null) {
			return null;
		}
		
		if (response.getUsers().size() == 0) {
			return null;
		}
		
		if (response.getUsers().size() > values.size()) {
			throw new IllegalStateException("Expected at most " + values.size() + " Users for " + field + " '" + valueList + "' but got " + response.getUsers().size());
		}
		
		final List<DiggUser> users = new ArrayList<DiggUser>(response.getUsers().size());
		
		for (final DiggUser user: response.getUsers().values()) {
			if (user.getId() == null) {
				throw new IllegalStateException("A User found for " + field + " '" + valueList + "' had null for its id");
			}
			
			if (user.getUsername() == null) {
				throw new IllegalStateException("A User found for " + field + " '" + valueList + "' had null for its username");
			}
			
			users.add(user);
		}
		
		return users;
	}
	
	/**
	 * Generic single user lookup.
	 *  
	 * @param field The friendly name for the field of the User that we are looking up by, either 'id' or 'username'.
	 * @param key The key for the ReST query, 'user_ids' or 'usernames'
	 * @param value Either the userId or the username to look up by
	 * @return The single User that matches, or null if none
	 * @throws IllegalStateException if more than one User matches, or the user has null id or username.
	 */
	private DiggUser getSingleUserByField(final String field, final String key, final String value) {
		final UserGetInfoResponse response = restTemplate.getForObject(buildUri("user.getInfo", key, value), UserGetInfoResponse.class);
		
		if (response == null) {
			return null;
		}
		
//		if (logger.isDebugEnabled()) {
			logger.warn(response.toString());
//		}
		
		if (response.getUsers() == null) {
			return null;
		}
		
		if (response.getUsers().size() == 0) {
			return null;
		}
		
		if (response.getUsers().size() > 1) {
			throw new IllegalStateException("Expected a single User for " + field + " '" + value + "' but got " + response.getUsers().size());
		}
		
		final DiggUser user = response.getUsers().values().iterator().next();

		if (user.getId() == null) {
			throw new IllegalStateException("Found a single User for " + field + " '" + value + "' but it had null for its id");
		}
		
		if (user.getUsername() == null) {
			throw new IllegalStateException("Found a single User for " + field + " '" + value + "' but it had null for its username");
		}
		
		return user;
	}

	public List<DiggUser> getInfoByUserIdList(final List<String> ids) {
		if (ids == null) {
			throw new IllegalArgumentException("ids must not be null");
		}
		
		if (ids.size() < 1) {
			throw new IllegalArgumentException("ids must not be empty");
		}
		
		return getUserListByField("id", "user_ids", ids);
	}

	public DiggUser getInfoByUserId(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("id must not be null");
		}
		
		final DiggUser user = getSingleUserByField("id", "user_ids", id);
		
		if ((user != null) && !user.getId().equals(id)) {
			throw new IllegalStateException("Found a single User for id '" + id + "' but it had a different id '" + user.getId() + "'!");
		}
		
		return user;
	}

	public List<DiggUser> getInfoByUsernameList(final List<String> usernames) {
		if (usernames == null) {
			throw new IllegalArgumentException("usernames must not be null");
		}
		
		if (usernames.size() < 1) {
			throw new IllegalArgumentException("usernames must not be empty");
		}
		
		return getUserListByField("id", "usernames", usernames);
	}

	public DiggUser getInfoByUsername(final String username) {
		if (username == null) {
			throw new IllegalArgumentException("username must not be null");
		}
		
		final DiggUser user = getSingleUserByField("username", "usernames", username);
		
		if ((user != null) && !user.getUsername().equals(username)) {
			throw new IllegalStateException("Found a single User for username '" + username + "' but it had a different username '" + user.getUsername() + "'!");
		}
		
		return user;
	}

	public String getUserId() {
		return null; //getUserProfile().getId();
	}

	public String getUsername() {
		return null; //getUserProfile().getUsername();
	}

	public Object getUserProfile() {
		/*
		 * The digg.getAll call has three parameters, but they are all optional. So, we could just call it with no args and ignore
		 * everything but the envelope user. However, we set the count to zero in case that makes it easier on the server since
		 * we won't be looking at any of the returned data.
		 * 
		 * FIXME: Unfortunately this call doesn't return the user stuff in the envelope :-(
		 */
//		final UserOnlyDiggResponse response = restTemplate.getForObject(buildUri("digg.getAll", "count", "0"), UserOnlyDiggResponse.class);
		@SuppressWarnings("rawtypes")
		final Map response = restTemplate.getForObject(buildUri("digg.getAll", "count", "0"), Map.class);
		
		if (response == null) {
			throw new IllegalStateException("Unable to get a response to digg.getAll call");
		}

//		final DiggUser user = response.getUser();
		final Object user = response.get("user");
		
		if (user == null) {
			final StringBuilder sb = new StringBuilder();
			
			for (final Object key: response.keySet()) {
				final Object value = response.get(key);
				sb.append(key);
				sb.append(" = ");
				sb.append(value);
				sb.append(";\n");
			}
			throw new IllegalStateException("Envelope of response to digg.getAll call did not contain info on logged in user: " + sb.toString());
		}
		
		return user;
	}

	public Map<String, Object> getMyNews() {
		try {
		@SuppressWarnings("unchecked")
			final Map<String, Object> response = restTemplate.getForObject(buildUri("user.getMyNews"), Map.class);
			return response;
		} catch (HttpClientErrorException e) {
			logger.error(e.getResponseBodyAsString());
			return null; // FIXME
		}
	}

	public Map<String, Object> getMyNews(int limit) {
		@SuppressWarnings("unchecked")
		final Map<String, Object> response = restTemplate.getForObject(buildUri("user.getMyNews", "limit", Integer.toString(limit)), Map.class);
		
		return response;
	}

	public DiggUser follow(final String username) {
		final UserFollowResponse response = restTemplate.getForObject(buildUri("user.follow", "username", username), UserFollowResponse.class);
		
		// FIXME: check _.isSuccess()		
		
		return response.getFollowedUser();
	}

	public DiggUser unfollow(final String username) {
		final UserUnfollowResponse response = restTemplate.getForObject(buildUri("user.unfollow", "username", username), UserUnfollowResponse.class);
		
		// FIXME: check _.isSuccess()
		
		return response.getUnfollowedUser();
	}
	
	public List<Story> getActivity(String username, ActivityType activityType, String cursor, Integer limit) {
		if (username == null) {
			throw new IllegalArgumentException("username must not be null");
		}
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
		parameters.set("username", username);
		
		if (activityType != null) {
			parameters.set("activity_type", activityType.toString());
		}
		
		if (cursor != null) {
			parameters.set("cursor", cursor);
		}
		
		if (limit != null) {
			parameters.set("limit", limit.toString());
		}
		
		final StoriesResponse response = restTemplate.getForObject(buildUri("user.getActivity", parameters), StoriesResponse.class);

		return response.getStories();
	}

}
