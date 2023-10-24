package lab2.developer.service.api;

import lab2.developer.entity.Developer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDeveloperService {
	Optional<Developer> find(UUID id);

	List<Developer> findAll();

	void create(Developer developer);

}
