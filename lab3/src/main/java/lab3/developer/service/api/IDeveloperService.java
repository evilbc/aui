package lab3.developer.service.api;

import lab3.developer.entity.Developer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDeveloperService {
	Optional<Developer> find(UUID id);

	List<Developer> findAll();

	void create(Developer developer);

	void update(Developer developer);

	void delete(UUID id);
}
