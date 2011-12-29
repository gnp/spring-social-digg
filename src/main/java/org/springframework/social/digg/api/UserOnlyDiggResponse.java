package org.springframework.social.digg.api;

public class UserOnlyDiggResponse {

	protected final DiggUser user;

	public UserOnlyDiggResponse(DiggUser user) {
		super();
		this.user = user;
	}

	public DiggUser getUser() {
		return user;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("UserOnlyDiggResponse:\n");
		sb.append("  user: " + user + "\n");
		
		return sb.toString();
	}

}