package lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4Game {
	public static void main(String[] args) {
		SpringApplication.run(lab4.Lab4Game.class, args);
	}

}
