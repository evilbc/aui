package lab1.developer.service.api;

import lab1.developer.entity.Developer;
import lab1.game.entity.Game;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDeveloperService {
	Optional<Developer> find(UUID id);

	List<Developer> findAll();

	void create(Developer developer);

}
