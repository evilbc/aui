package lab4.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4Gateway {
	public static void main(String[] args) {
		SpringApplication.run(Lab4Gateway.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder, @Value("${lab4.game.url}") String gameUrl,
			@Value("${lab4.developer.url}") String developerUrl, @Value("${lab4.gateway.host}") String host) {
		return builder.routes()
				.route("developers", route -> route.host(host)
						.and()
						.path("/api/developers/{uuid}", "/api/developers")
						.uri(developerUrl))
				.route("games", route -> route.host(host)
						.and()
						.path("/api/games", "/api/games/**", "/api/developers/{uuid}/games",
								"/api/developers/{uuid}/games/**")
						.uri(gameUrl))
				.build();
	}

}
