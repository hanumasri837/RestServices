package com.projectcodeforce.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.projectcodeforce.dao")
@SpringBootApplication
public class Projectcodeforce1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projectcodeforce1Application.class, args);
	}

}
