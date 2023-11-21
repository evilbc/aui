package lab4.developer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4Developer {
	public static void main(String[] args) {
		SpringApplication.run(Lab4Developer.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

}
