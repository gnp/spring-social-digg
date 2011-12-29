package org.springframework.social.digg.api.impl;

import java.util.EnumSet;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.digg.api.ActivityType;
import org.springframework.social.digg.api.DiggUser;
import org.springframework.social.digg.api.Topic;


/**
 * Mixin class for adding Jackson annotations to DiggUser.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoryMixin {
	
	@JsonCreator
    StoryMixin(
			@JsonProperty("story_id") String id,
			@JsonProperty("permalink") String permalink,
			@JsonProperty("url") String url,
			@JsonProperty("shorturl") String shortUrl,
			@JsonProperty("title") String title,
			@JsonProperty("description") String description,
			@JsonProperty("topic") Topic topic,
			@JsonProperty("status") String status,
			@JsonProperty("submiter" /* [sic] */) DiggUser submitter,
			@JsonProperty("comments") int comments,
			@JsonProperty("diggs") int diggs,
			@JsonProperty("dugg") int dugg,
			@JsonProperty("promote_date") Integer promoteDate,
			@JsonProperty("date_created") int dateCreated,
			@JsonProperty("activity") EnumSet<ActivityType> activities) { }
	
}
