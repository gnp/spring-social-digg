package org.springframework.social.digg.api.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.digg.api.RawOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


public class RawTemplate extends AbstractDiggOperations implements RawOperations {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RawTemplate.class);

	private final RestTemplate restTemplate;

	public RawTemplate(final RestTemplate restTemplate, final boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	private Map<String, Object> rawCallInternal(final String method, final String[] args) {
		final MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
		if (args != null) {
			if (args.length % 2 != 0) {
				throw new IllegalArgumentException("Must have an even number of args for them to be interpreted as key-value pairs!");
			}
			
			for (int i = 0; i < args.length - 1; ) {
				final String key = args[i];
				final String value = args[i + 1];
				
				parameters.add(key, value);
				
				i += 2;
			}
		}
		
		@SuppressWarnings("unchecked")
		final Map<String, Object> response = restTemplate.getForObject(buildUri("digg.getAll", parameters), Map.class);

		return response;
	}

	public Map<String, Object> rawCall(final String method, final String... args) {
		return rawCallInternal(method, args);
	}

	public Map<String, Object> rawCall(String method) {
		return rawCallInternal(method, null);
	}
	
}
