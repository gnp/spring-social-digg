package org.springframework.social.digg.api;

public class UserUnfollowResponse extends BaseDiggResponse {

	private final boolean success;
	private final DiggUser unfollowedUser;
	
	public UserUnfollowResponse(String authorized, int count, String cursor, String data, String method, int timestamp, DiggUser user, String version, String title, String uri, boolean success, DiggUser followedUser) {
		super(authorized, count, cursor, data, method, timestamp, user, version, title, uri);
		this.success = success;
		this.unfollowedUser = followedUser;
	}

	public DiggUser getUnfollowedUser() {
		return unfollowedUser;
	}

	public boolean isSuccess() {
		return success;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("UserGetInfoResponse:\n");
		sb.append("  authorized: " + authorized + "\n");
		sb.append("  count: " + count + "\n");
		sb.append("  cursor: " + cursor + "\n");
		sb.append("  data: " + data + "\n");
		sb.append("  method: " + method + "\n");
		sb.append("  timestamp: " + timestamp + "\n");
		sb.append("  user: " + user + "\n");
		sb.append("  version: " + version + "\n");
		sb.append("  title: " + title + "\n");
		sb.append("  uri: " + uri + "\n");
		sb.append("  success: " + success + "\n");
		sb.append("  unfollowedUser: " + unfollowedUser + "\n");
		
		return sb.toString();
	}

}
