package org.springframework.social.digg.api.impl;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.digg.api.DiggUser;


/**
 * Mixin class for adding Jackson annotations to UserGetInfoReponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserGetInfoResponseMixin {

	@JsonCreator
	UserGetInfoResponseMixin(
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
			@JsonProperty("users") Map<String, DiggUser> users) {
	}

}
