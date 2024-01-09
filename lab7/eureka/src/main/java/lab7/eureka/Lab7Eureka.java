package lab7.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab7Eureka {
	public static void main(String[] args) {
		SpringApplication.run(Lab7Eureka.class, args);
	}

}
