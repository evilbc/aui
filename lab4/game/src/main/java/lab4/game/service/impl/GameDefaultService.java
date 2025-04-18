package lab4.game.service.impl;

import lab4.developer.entity.Developer;
import lab4.developer.repository.IDeveloperRepository;
import lab4.game.entity.Game;
import lab4.game.repository.IGameRepository;
import lab4.game.service.api.IGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class GameDefaultService implements IGameService {
	private final IGameRepository repository;
	private final IDeveloperRepository developerRepository;

	@Override
	public Optional<Game> find(UUID id) {
		log.info("Finding game with id {}", id);
		return repository.findById(id);
	}

	@Override
	public List<Game> findAll() {
		log.info("Finding all games");
		return repository.findAll();
	}

	@Override
	public List<Game> findAll(Developer developer) {
		log.info("Finding all games of developer {}", developer);
		return repository.findAllByDeveloper(developer);
	}

	@Override
	public void create(Game game) {
		log.info("Creating game {}", game);
		if (developerRepository.findById(game.getDeveloper().getId()).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer not found");
		}
		repository.save(game);
	}

	@Override
	public void update(Game game) {
		log.info("Updating game {}", game);
		repository.save(game);
	}

	@Override
	public void delete(UUID id) {
		log.info("Deleting game with id {}", id);
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		log.info("Deleting all games");
		repository.deleteAll();
	}

	@Override
	public Optional<List<Game>> findAllByDeveloper(UUID developerId) {
		log.info("Finding all games of developer with id {}", developerId);
		return developerRepository.findById(developerId)
				.map(this::findAll);
	}
}
