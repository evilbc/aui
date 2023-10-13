package lab1.developer.service.impl;

import lab1.developer.entity.Developer;
import lab1.developer.repository.IDeveloperRepository;
import lab1.developer.service.api.IDeveloperService;
import lab1.game.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeveloperDefaultService implements IDeveloperService {
	private final IDeveloperRepository repository;

	@Override
	public Optional<Developer> find(UUID id) {
		return repository.findById(id);
	}

	@Override
	public List<Developer> findAll() {
		return repository.findAll();
	}

	@Override
	public void create(Developer developer) {
		repository.save(developer);
	}
}
