package com.example.ferramentas;

import com.example.ferramentas.model.User;
import com.example.ferramentas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FerramentasApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FerramentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.findByUsername("admin") == null) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin123"));
			admin.setRole("ADMIN");
			userRepository.save(admin);
			System.out.println("Admin user created: admin/admin123");
		}
	}

}
