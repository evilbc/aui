package lab7.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lab7Configuration {
	public static void main(String[] args) {
		SpringApplication.run(Lab7Configuration.class, args);
	}

}
