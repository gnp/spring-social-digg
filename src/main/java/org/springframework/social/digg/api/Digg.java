package org.springframework.social.digg.api;

import org.springframework.social.ApiBinding;

public interface Digg extends ApiBinding {

	/**
	 * API for performing operations with users.
	 */
	UserOperations userOperations();

	/**
	 * Performing raw calls for troubleshooting
	 * 
	 * @return
	 */
	RawOperations rawOperations();
	
}