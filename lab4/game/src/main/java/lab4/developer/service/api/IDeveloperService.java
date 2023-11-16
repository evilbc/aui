package lab4.developer.service.api;

import lab4.developer.entity.Developer;

import java.util.Optional;
import java.util.UUID;

public interface IDeveloperService {
	Optional<Developer> find(UUID id);

	void create(Developer developer);

	void delete(UUID id);

	void deleteAll();
}
