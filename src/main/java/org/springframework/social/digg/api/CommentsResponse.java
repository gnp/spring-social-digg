package org.springframework.social.digg.api;

import java.util.List;

public class CommentsResponse extends BaseDiggResponse {

	private final List<Comment> comments;
	
	public CommentsResponse(String authorized, int count, String cursor, String data, String method, int timestamp, DiggUser user, String version, String title, String uri, List<Comment> comments) {
		super(authorized, count, cursor, data, method, timestamp, user, version, title, uri);
		this.comments = comments;
	}

	public List<Comment> getStories() {
		return comments;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("CommentsResponse:\n");
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
		sb.append("  comments: " + comments + "\n");
		
		return sb.toString();
	}

}
