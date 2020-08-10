package com.wipro.digital.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to App 1.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * 
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
}
