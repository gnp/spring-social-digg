package org.springframework.social.digg.api.impl;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to DiggUser.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class DiggUserMixin {

	@JsonCreator
	DiggUserMixin(@JsonProperty("user_id") String id,
			@JsonProperty("username") String username,
			@JsonProperty("name") String name,
			@JsonProperty("about") String about,
			@JsonProperty("gender") String gender,
			@JsonProperty("icons") Set<String> icons,
			@JsonProperty("icon") String icon,
			@JsonProperty("location") String location,
			@JsonProperty("followers") int followers,
			@JsonProperty("following") int following,
			@JsonProperty("submissions") int submissions,
			@JsonProperty("comments") int comments,
			@JsonProperty("diggs") int diggs) {
	}
}
