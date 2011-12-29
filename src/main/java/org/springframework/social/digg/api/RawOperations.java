package org.springframework.social.digg.api;

import java.util.Map;

public interface RawOperations {

	public Map<String, Object> rawCall(String method, String... args);
	public Map<String, Object> rawCall(String method);
	
}
