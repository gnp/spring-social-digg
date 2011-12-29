package org.springframework.social.digg.api;

import java.util.List;

public class StoriesResponse extends BaseDiggResponse {

	private final List<Story> stories;
	
	public StoriesResponse(String authorized, int count, String cursor, String data, String method, int timestamp, DiggUser user, String version, String title, String uri, List<Story> stories) {
		super(authorized, count, cursor, data, method, timestamp, user, version, title, uri);
		this.stories = stories;
	}

	public List<Story> getStories() {
		return stories;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("StoriesResponse:\n");
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
		sb.append("  stories: " + stories + "\n");
		
		return sb.toString();
	}

}
