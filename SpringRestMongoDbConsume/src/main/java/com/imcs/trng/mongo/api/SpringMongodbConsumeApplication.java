package com.imcs.trng.mongo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.imcs.trng.rest.consume"})
public class SpringMongodbConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbConsumeApplication.class, args);
	}
}
