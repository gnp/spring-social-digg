package org.springframework.social.digg.api.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.digg.api.DiggUser;
import org.springframework.social.digg.api.Story;


/**
 * Mixin class for adding Jackson annotations to StoriesReponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class StoriesResponseMixin {

	@JsonCreator
	StoriesResponseMixin(
			@JsonProperty("authorized") String authorized,
			@JsonProperty("count") int count,
			@JsonProperty("cursor") String cursor,
			@JsonProperty("data") String data,
			@JsonProperty("method") String method,
			@JsonProperty("timestamp") int timestamp,
			@JsonProperty("user") DiggUser user,
			@JsonProperty("version") String version,
			@JsonProperty("title") String title,
			@JsonProperty("uri") String uri,
			@JsonProperty("stories") List<Story> stories) {
	}

}
