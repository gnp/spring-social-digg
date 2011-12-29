package org.springframework.social.digg.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.digg.api.Digg;


/**
 * Digg ConnectionFactory implementation.
 */
public class DiggConnectionFactory extends OAuth1ConnectionFactory<Digg> {

	public DiggConnectionFactory(final String apiKey, final String secretKey) {
		super("digg", new DiggServiceProvider(apiKey, secretKey), new DiggAdapter());
	}

}
