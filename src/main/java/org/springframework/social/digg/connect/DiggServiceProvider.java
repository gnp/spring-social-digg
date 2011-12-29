package org.springframework.social.digg.connect;

import org.springframework.social.digg.api.Digg;
import org.springframework.social.digg.api.impl.DiggTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;


/**
 * Digg ServiceProvider implementation.
 */
public class DiggServiceProvider extends AbstractOAuth1ServiceProvider<Digg> {

	public DiggServiceProvider(String apiKey, String secretKey) {
		super(apiKey, secretKey, new OAuth1Template(apiKey, secretKey,
			"http://services.digg.com/oauth/request_token", // FIXME: Shouldn't some of these be https, really?
			"http://digg.com/oauth/authorize",
			"http://digg.com/oauth/authenticate",
			"http://services.digg.com/oauth/access_token"));
	}

	public Digg getApi(String accessToken, String secret) {
		return new DiggTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}
	
}