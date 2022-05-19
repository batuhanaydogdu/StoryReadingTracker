package com.impostors.app.ws.storyreadingtrackerws;

import com.impostors.app.ws.storyreadingtrackerws.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StoryReadingTrackerWsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StoryReadingTrackerWsApplication.class, args);
	}




	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StoryReadingTrackerWsApplication.class);
	}


	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean(name="AppProperties")
	public AppProperties appProperties() {
		return new AppProperties();// name can be given different from name="appProperties" because default is appProperties
	}

}
