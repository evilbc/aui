package lab4.developer.event.repository.api;

import lab4.developer.dto.PutDeveloperRequest;

import java.util.UUID;

public interface IDeveloperEventRepository {
	void create(UUID id);

	void delete(UUID id);
}
