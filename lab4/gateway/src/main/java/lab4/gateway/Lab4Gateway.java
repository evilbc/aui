package lab4.gateway;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class Lab4Gateway {
	public static void main(String[] args) {
		SpringApplication.run(Lab4Gateway.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder, @Value("${lab4.gateway.host}") String host) {
		return builder.routes()
				.route("developers", route -> route.host(host)
						.and()
						.path("/api/developers/{uuid}", "/api/developers")
						.uri("lb://developer"))
				.route("games", route -> route.host(host)
						.and()
						.path("/api/games", "/api/games/**", "/api/developers/{uuid}/games",
								"/api/developers/{uuid}/games/**")
						.uri("lb://game"))
				.build();
	}
}
