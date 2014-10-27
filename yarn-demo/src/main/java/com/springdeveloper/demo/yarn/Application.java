package com.springdeveloper.demo.yarn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.yarn.annotation.OnContainerStart;
import org.springframework.yarn.annotation.YarnComponent;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		new HelloPojo();
		SpringApplication.run(Application.class, args);
	}

	@YarnComponent
	@Profile("container")
	public static class HelloPojo {

		private static final Log log = LogFactory.getLog(HelloPojo.class);

		@OnContainerStart
		public void onStart() {
			log.info("Hello from YARN!");
		}
	}
}
