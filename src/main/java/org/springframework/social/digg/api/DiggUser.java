package org.springframework.social.digg.api;

import java.util.Set;

public class DiggUser {
	
	private final String id;

	private final String username;

	private final String name;
	
	private final String about;
	
	private final String gender;
	
	private final Set<String> icons;
	
	private final String icon;
	
	private final String location;
	
	private final int followers;
	
	private final int following;
	
	private final int submissions;
	
	private final int comments;
	
	private final int diggs;
	
	public DiggUser(String id, String username, String name, String about, String gender, Set<String> icons, String icon, String location, int followers, int following, int submissions, int comments, int diggs) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.about = about;
		this.gender = gender;
		this.icons = icons;
		this.icon = icon;
		this.location = location;
		this.followers = followers;
		this.following = following;
		this.submissions = submissions;
		this.comments = comments;
		this.diggs = diggs;
	}

	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	/**
	 * The user's full name
	 * @return The user's full name
	 */
	public String getName() {
		return name;
	}

	public String getAbout() {
		return about;
	}

	public int getFollowers() {
		return followers;
	}

	public int getFollowing() {
		return following;
	}

	public String getGender() {
		return gender;
	}

	public Set<String> getIcons() {
		return icons;
	}
	public String getIcon() {
		return icon;
	}

	public String getLocation() {
		return location;
	}

	public int getSubmissions() {
		return submissions;
	}

	public int getComments() {
		return comments;
	}

	public int getDiggs() {
		return diggs;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("DiggUser:\n");
		sb.append("  id: " + id + "\n");
		sb.append("  username: " + username + "\n");
		sb.append("  name: " + name + "\n");
		sb.append("  about: " + about + "\n");
		sb.append("  gender: " + gender + "\n");
		sb.append("  icons: " + icons + "\n");
		sb.append("  icon: " + icon + "\n");
		sb.append("  location: " + location + "\n");
		sb.append("  followers: " + followers + "\n");
		sb.append("  following: " + following + "\n");
		sb.append("  submissions: " + submissions + "\n");
		sb.append("  comments: " + comments + "\n");
		sb.append("  diggs: " + diggs + "\n");
		
		return sb.toString();
	}
	
}
