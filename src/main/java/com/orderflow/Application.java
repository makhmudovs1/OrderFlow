package com.orderflow;

import com.orderflow.models.Client;
import com.orderflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.existsByEmail("sher@gmail.com")) {
			System.out.println("Error: Email is already in use!");
		} else {
			Client client = new Client();
			client.setUsername("Sher");
			client.setPassword(passwordEncoder.encode("sher"));
			client.setEmail("sher@gmail.com");
			client.setPhone("123123123");

			userRepository.save(client);

			System.out.println(client.getUsername());
		}
	}
}
