package lab4.developer.event.repository.impl;

import lab4.developer.event.repository.api.IDeveloperEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class DeveloperEventRepository implements IDeveloperEventRepository {
	private final RestTemplate restTemplate;
	private final LoadBalancerClient loadBalancerClient;

	private String getBaseUri() {
		return loadBalancerClient.choose("game")
				.getUri()
				.toString();
	}

	@Override
	public void create(UUID id) {
		restTemplate.put(getBaseUri() + "/api/developers/{id}", null, id);
	}

	@Override
	public void delete(UUID id) {
		restTemplate.delete(getBaseUri() + "/api/developers/{id}", id);
	}
}
