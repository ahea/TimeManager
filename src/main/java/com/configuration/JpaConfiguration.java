package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by aleksei on 22.01.17.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.repositories"})
public class JpaConfiguration {
}
