package org.springframework.social.digg.api;

public enum ActivityType {
	
	digg, comment, submission; // FIXME: The upper-case with lower case value did not map with Jackson using ToStringMixin...

//	Digg("digg"), Comment("comment"), Submission("submission");
//	
//	private final String value;
//	
//	private ActivityType(final String value) {
//		this.value = value;
//	}
//
//	@Override
//	public String toString() {
//		return value;
//	}	
	
}
