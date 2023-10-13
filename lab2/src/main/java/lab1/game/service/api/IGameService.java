package lab1.game.service.api;

import lab1.developer.entity.Developer;
import lab1.game.entity.Game;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGameService {
	Optional<Game> find(UUID id);

	List<Game> findAll();

	List<Game> findAll(Developer developer);

	void create(Game game);

	void update(Game game);

	void delete(UUID id);

	Optional<List<Game>> findAllByDeveloper(UUID developerId);
}
