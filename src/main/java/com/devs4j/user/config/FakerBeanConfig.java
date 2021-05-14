/**
 * 
 */
package com.devs4j.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

/**
 * @author jpr6a
 *
 */
@Configuration
public class FakerBeanConfig {
	
	@Bean
	public Faker getFaker() {
		return new Faker();
	}
}
