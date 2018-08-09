package sne.chaka.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "hello", ignoreUnknownFields = false)
@Getter
@Setter
public class HelloProperties {

	/**
	 * Prefix welcome message
	 */
	private String prefix = "Hello";

	/**
	 * Target welcom message
	 */
	private String target;
}
