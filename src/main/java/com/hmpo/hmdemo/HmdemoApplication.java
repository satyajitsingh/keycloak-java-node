package com.hmpo.hmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmdemoApplication {

	public static void main(String[] args) {
		System.out.println("In Java Keycloak application");
		SpringApplication.run(HmdemoApplication.class, args);
	}

}
