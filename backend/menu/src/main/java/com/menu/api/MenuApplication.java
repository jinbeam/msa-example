package com.menu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJpaAuditing
public class MenuApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}
}
