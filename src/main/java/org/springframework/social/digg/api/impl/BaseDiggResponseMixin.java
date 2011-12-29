package org.springframework.social.digg.api.impl;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to GetInforReponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BaseDiggResponseMixin {

	@JsonCreator
	BaseDiggResponseMixin(
			@JsonProperty("authorized") String authorized,
			@JsonProperty("count") int count,
			@JsonProperty("cursor") String cursor,
			@JsonProperty("data") String data,
			@JsonProperty("method") String method,
			@JsonProperty("timestamp") int timestamp,
			@JsonProperty("user") Map<String, Object> user,
			@JsonProperty("version") String version,
			@JsonProperty("title") String title,
			@JsonProperty("uri") String uri) {
	}

}
