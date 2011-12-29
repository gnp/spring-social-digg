package org.springframework.social.digg.api;

import java.util.List;
import java.util.Map;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;

public interface UserOperations {
	
	/**
	 * Follow a user, identified by username.
	 * 
	 * @param username of the user to follow
	 * @return the user information for the followed user.
	 */
	DiggUser follow(String username);
	
	/**
	 * Retrieve user activity, such as diggs, comments and/or submissions.
	 * 
	 * @param username Required
	 * @param activityType Optional
	 * @param cursor Optional
	 * @param limit Optional
	 * @return a list of stories
	 */
	List<Story> getActivity(String username, ActivityType activityType, String cursor, Integer limit);

	
	//List<Comment> getComments(String username, String cursor, Integer limit);

	/**
	 * Retrieves a specific Digg user's  details.
	 * Note that this method does not require authentication.
	 * @param userId the user ID for the user whose details are to be retrieved.
	 * @return a {@link TwitterProfile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 */
	DiggUser getInfoByUserId(String id);
	
	List<DiggUser> getInfoByUserIdList(List<String> ids);
	
	/**
	 * Retrieves a specific Digg user's details.
	 * Note that this method does not require authentication.
	 * @param screenName the screen name for the user whose details are to be retrieved.
	 * @return a {@link TwitterProfile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with Twitter.
	 */
	DiggUser getInfoByUsername(String username);

	List<DiggUser> getInfoByUsernameList(List<String> usernames);
	
	// FIXME: Real return type
	Map<String, Object> getMyNews();

	// FIXME: Real return type
	Map<String, Object> getMyNews(int limit);

	/**
	 * @param cursor Optional
	 * @param limit Optional
	 * @return List of Stories
	 */
	//List<Story> getSavedStories(String cursor, Integer limit);
	
	/**
	 * Retrieves the authenticated user's Digg ID.
	 * @return the user's ID at Digg
	 * @throws ApiException if there is an error while communicating with Digg.
	 * @throws MissingAuthorizationException if DiggTemplate was not created with OAuth credentials.
	 */
	String getUserId();
	
	/**
	 * Retrieves the authenticated user's Digg username
	 * @return the user's username
	 * @throws ApiException if there is an error while communicating with Digg.
	 * @throws MissingAuthorizationException if DiggTemplate was not created with OAuth credentials.
	 */
	String getUsername();
	
	/**
	 * Retrieves the authenticated Digg user's details.
	 * @return a {@link DiggUser} object representing the user.
	 * @throws ApiException if there is an error while communicating with Digg.
	 * @throws MissingAuthorizationException if DiggTemplate was not created with OAuth credentials.
	 */
	Object getUserProfile();
	
	/*
	void removeStory(String id);
	
	void removeStories(List<String> ids);
	
	void saveStory(String id);
	
	void saveStories(List<String> ids);
	*/
	
	DiggUser unfollow(String username);
}
