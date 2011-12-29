package org.springframework.social.digg.api;

import java.util.EnumSet;

public class Story {
	
	private final String id;

	private final String permalink;

	private final String url;
	
	private final String shortUrl;
	
	private final String title;
	
	private final String description;
	
	private final Topic topic;

	private final String status;
			
	private final DiggUser submitter;
		
	private final int comments;
	
	private final int diggs;
	
	private final int dugg;
	
	private final Integer promoteDate;
	
	private final int dateCreated;
	
	private final EnumSet<ActivityType> activities;
	
	public Story(String id, String permalink, String url, String shortUrl, String title, String description, Topic topic, String status, DiggUser submitter, int comments, int diggs, int dugg, Integer promoteDate, int dateCreated, EnumSet<ActivityType> activities) {
		this.id = id;
		this.permalink = permalink;
		this.url = url;
		this.shortUrl = shortUrl;
		this.title = title;
		this.description = description;
		this.topic = topic;
		this.status = status;
		this.submitter = submitter;
		this.comments = comments;
		this.diggs = diggs;
		this.dugg = dugg;
		this.promoteDate = promoteDate;
		this.dateCreated = dateCreated;
		this.activities = activities;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();

		sb.append("Story:\n");
		sb.append("  id: " + id + "\n");
		sb.append("  permalink: " + permalink + "\n");
		sb.append("  url: " + url + "\n");
		sb.append("  shortUrl: " + shortUrl + "\n");
		sb.append("  title: " + title + "\n");
		sb.append("  description: " + description + "\n");
		sb.append("  topic: " + topic + "\n");
		sb.append("  status: " + status + "\n");
		sb.append("  submitter: " + submitter + "\n");
		sb.append("  comments: " + comments + "\n");
		sb.append("  diggs: " + diggs + "\n");
		sb.append("  dugg: " + dugg + "\n");
		sb.append("  promoteDate: " + promoteDate + "\n");
		sb.append("  dateCreated: " + dateCreated + "\n");
		sb.append("  activities: " + activities + "\n");
		
		return sb.toString();
	}
	
}
