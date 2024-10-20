package com.orderflow;

import com.orderflow.models.Client;
import com.orderflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client();
		client.setUsername("Sher");
		client.setPassword("sher");
		client.setEmail("sher@gmail.com");
		client.setPhone("123123123");

		userRepository.save(client);

		System.out.println(client.getUsername());
	}
}
