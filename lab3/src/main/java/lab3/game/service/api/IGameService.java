package lab3.game.service.api;

import lab3.developer.entity.Developer;
import lab3.game.entity.Game;

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
