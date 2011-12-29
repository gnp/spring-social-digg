package org.springframework.social.digg.api.impl;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to Topic.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
abstract class TopicMixin {

	@JsonCreator
	TopicMixin(@JsonProperty("name") String name,
			@JsonProperty("clean_name") String cleanName) {
	}
	
}
