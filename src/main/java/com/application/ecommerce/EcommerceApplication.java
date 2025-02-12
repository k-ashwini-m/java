package com.application.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.ecommerce.entities.Role;
import com.application.ecommerce.entities.User;
import com.application.ecommerce.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.application.ecommerce")
public class EcommerceApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	public void run(String... args) {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin")); 
			userRepository.save(user);
		}
	}

}
