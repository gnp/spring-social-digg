package org.springframework.social.digg.api.impl;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.digg.api.BaseDiggResponse;
import org.springframework.social.digg.api.DiggUser;
import org.springframework.social.digg.api.StoriesResponse;
import org.springframework.social.digg.api.Story;
import org.springframework.social.digg.api.Topic;
import org.springframework.social.digg.api.UserFollowResponse;
import org.springframework.social.digg.api.UserGetInfoResponse;
import org.springframework.social.digg.api.UserOnlyDiggResponse;
import org.springframework.social.digg.api.UserUnfollowResponse;


/**
 * Jackson module for registering mixin annotations against Digg model classes.
 */
class DiggModule extends SimpleModule {
	public DiggModule() {
		super("DiggModule", new Version(1, 0, 0, null));
	}
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(UserOnlyDiggResponse.class, UserOnlyDiggResponseMixin.class);
		context.setMixInAnnotations(BaseDiggResponse.class, BaseDiggResponseMixin.class);
		context.setMixInAnnotations(Topic.class, TopicMixin.class);
		context.setMixInAnnotations(UserGetInfoResponse.class, UserGetInfoResponseMixin.class);
		context.setMixInAnnotations(UserFollowResponse.class, UserFollowResponseMixin.class);
		context.setMixInAnnotations(UserUnfollowResponse.class, UserUnfollowResponseMixin.class);
		context.setMixInAnnotations(DiggUser.class, DiggUserMixin.class);
		context.setMixInAnnotations(Story.class, StoryMixin.class);
		context.setMixInAnnotations(StoriesResponse.class, StoriesResponseMixin.class);
	}
}
