package com.adjoda;

import com.adjoda.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringBoot3SecurityJwtApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3SecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.handleCreateAdminUser();
	}
}
