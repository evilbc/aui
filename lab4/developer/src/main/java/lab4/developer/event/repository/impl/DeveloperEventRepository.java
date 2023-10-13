package lab4.developer.event.repository.impl;

import lab4.developer.event.repository.api.IDeveloperEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class DeveloperEventRepository implements IDeveloperEventRepository {
	private final RestTemplate restTemplate;

	@Override
	public void create(UUID id) {
		restTemplate.put("/api/developers/{id}", null, id);
	}

	@Override
	public void delete(UUID id) {
		restTemplate.delete("/api/developers/{id}", id);
	}
}
