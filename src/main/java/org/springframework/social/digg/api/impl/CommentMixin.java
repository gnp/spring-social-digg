package org.springframework.social.digg.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to DiggUser.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentMixin {
	
	@JsonCreator
    CommentMixin(
			@JsonProperty("comment_id") String id,
			@JsonProperty("comment_text") String text,
			@JsonProperty("parent_id") String parentId,
			@JsonProperty("diggs") int diggs,
			@JsonProperty("buries") int buries,
			@JsonProperty("date_created") int dateCreated) { }
	
}
