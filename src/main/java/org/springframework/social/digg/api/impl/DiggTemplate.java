package org.springframework.social.digg.api.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.digg.api.Digg;
import org.springframework.social.digg.api.RawOperations;
import org.springframework.social.digg.api.UserOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


/**
 * This is the central class for interacting with Digg.
 * <p>
 * Some (not all) Digg operations require OAuth authentication. To perform
 * such operations, {@link DiggTemplate} must be constructed with the minimal
 * amount of information required to sign requests to Digg's API with an
 * OAuth <code>Authorization</code> header.
 * </p>
 * <p>
 * There are some operations, FIXME: {such as searching}, that do not require OAuth
 * authentication. In those cases, you may use a {@link DiggTemplate} that is
 * created through the default constructor and without any OAuth details.
 * Attempts to perform secured operations through such an instance, however,
 * will result in {@link NotAuthorizedException} being thrown.
 * </p>
 */
public class DiggTemplate extends AbstractOAuth1ApiBinding implements Digg {
	
	private UserOperations userOperations;
	
	private RawOperations rawOperations;

	/**
	 * Create a new instance of DiggTemplate.
	 * This constructor creates a new DiggTemplate able to perform unauthenticated operations against Digg's API.
	 * Some operations, such as search, do not require OAuth authentication.
	 * A DiggTemplate created with this constructor will support those operations.
	 * Any operations requiring authentication will throw {@link NotAuthorizedException} .
	 */
	public DiggTemplate() {
		super();
		initSubApis();
	}

	/**
	 * Create a new instance of DiggTemplate.
	 * @param consumerKey the application's API key
	 * @param consumerSecret the application's API secret
	 * @param accessToken an access token acquired through OAuth authentication with Digg
	 * @param accessTokenSecret an access token secret acquired through OAuth authentication with Digg
	 */
	public DiggTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initSubApis();
	}
	
	public UserOperations userOperations() {
		return userOperations;
	}
	
	public RawOperations rawOperations() {
		return rawOperations;
	}
	
	// AbstractOAuth1ApiBinding hooks
	
	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();				
		objectMapper.registerModule(new DiggModule());
		converter.setObjectMapper(objectMapper);		
		return converter;
	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler()); /* FIXME: Twitter has a custom one... */
	}
	
	// private helper 

	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
		this.rawOperations = new RawTemplate(getRestTemplate(), isAuthorized());
	}

}