package org.springframework.social.digg.api;

public class BaseDiggResponse {

	protected final String authorized;
	protected final int count;
	protected final String cursor;
	protected final String data;
	protected final String method;
	protected final int timestamp;
	protected final DiggUser user;
	protected final String version;
	protected final String title;
	protected final String uri;

	public BaseDiggResponse(String authorized, int count, String cursor, String data, String method, int timestamp, DiggUser user, String version, String title, String uri) {
		super();
		this.authorized = authorized;
		this.count = count;
		this.cursor = cursor;
		this.data = data;
		this.method = method;
		this.timestamp = timestamp;
		this.user = user;
		this.version = version;
		this.title = title;
		this.uri = uri;
	}

	public String getAuthorized() {
		return authorized;
	}

	public int getCount() {
		return count;
	}

	public String getCursor() {
		return cursor;
	}

	public String getData() {
		return data;
	}

	public String getMethod() {
		return method;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public DiggUser getUser() {
		return user;
	}

	public String getVersion() {
		return version;
	}

	public String getTitle() {
		return title;
	}

	public String getUri() {
		return uri;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("BaseDiggResponse:\n");
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
		
		return sb.toString();
	}

}