package org.springframework.social.digg.api.impl;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.digg.api.DiggUser;


/**
 * Mixin class for adding Jackson annotations to GetInforReponse.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserOnlyDiggResponseMixin {

	@JsonCreator
	UserOnlyDiggResponseMixin(
			@JsonProperty("user") DiggUser user) {
	}

}
