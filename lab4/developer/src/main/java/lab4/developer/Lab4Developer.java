package lab4.developer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab4Developer {
	public static void main(String[] args) {
		SpringApplication.run(Lab4Developer.class, args);
	}

	@Bean
	RestTemplate restTemplate(@Value("${lab4.game.url}") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl)
				.build();
	}

}
