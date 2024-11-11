package com.example.onlineticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.onlineticketing.comms.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class OnlineticketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineticketingApplication.class, args);
	}

}
