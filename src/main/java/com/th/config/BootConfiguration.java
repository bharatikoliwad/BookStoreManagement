package com.th.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * BootConfigaration class provides the beans to be configered at the run time
 * 
 * @author bharati_koliwad,rakshita_prakash
 *
 */

@Configuration
public class BootConfiguration {
	/**
	 * Used to Encrypt password using Bcrypt algorithm
	 * 
	 * @return {@link PasswordEncoder} which helps to decrypt, encrypt and match a
	 *         password
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
