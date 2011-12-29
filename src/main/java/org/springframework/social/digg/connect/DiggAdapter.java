package org.springframework.social.digg.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.digg.api.Digg;


/**
 * Digg ApiAdapter implementation.
 */
public class DiggAdapter implements ApiAdapter<Digg> {

	private static final String DIGG_USER_ID = "-1";
	private static final String DIGG_USERNAME = "nobody";
	private static final String DIGG_NAME = "Buddy Noah";
	
	/**
	 * FIXME: Do something real here
	 */
	public boolean test(final Digg digg) {
//		try {
//			digg.userOperations().getUserProfile();
			return true;
//		} catch (ApiException e) {
//			return false;
//		}
	}

	public void setConnectionValues(final Digg digg, final ConnectionValues values) {
//		TwitterProfile profile = digg.userOperations().getUserProfile();
		values.setProviderUserId(DIGG_USER_ID);
		values.setDisplayName(DIGG_USERNAME);
//		values.setProfileUrl(profile.getProfileUrl());
//		values.setImageUrl(profile.getProfileImageUrl());
	}

	public UserProfile fetchUserProfile(final Digg digg) {
//		DiggUser user = digg.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(DIGG_NAME).setUsername(DIGG_USERNAME).build();
	}
	
	public void updateStatus(final Digg digg, final String message) {
//		digg.timelineOperations().updateStatus(message);	
	}
	
}