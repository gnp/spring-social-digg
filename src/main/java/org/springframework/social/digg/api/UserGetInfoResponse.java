package org.springframework.social.digg.api;

import java.util.Map;

public class UserGetInfoResponse extends BaseDiggResponse {

	private final Map<String, DiggUser> users;
	
	public UserGetInfoResponse(String authorized, int count, String cursor, String data, String method, int timestamp, DiggUser user, String version, String title, String uri, Map<String, DiggUser> users) {
		super(authorized, count, cursor, data, method, timestamp, user, version, title, uri);
		this.users = users;
	}

	public Map<String, DiggUser> getUsers() {
		return users;
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
		sb.append("  users: " + users + "\n");
		
		return sb.toString();
	}

}
