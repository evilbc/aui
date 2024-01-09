package lab4.developer.service.impl;

import lab4.developer.entity.Developer;
import lab4.developer.repository.IDeveloperRepository;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class DeveloperDefaultService implements IDeveloperService {
	private final IDeveloperRepository repository;

	@Override
	public Optional<Developer> find(UUID id) {
		log.info("Finding developer with id {}", id);
		return repository.findById(id);
	}

	@Override
	public void create(Developer developer) {
		log.info("Creating developer {}", developer);
		repository.save(developer);
	}

	@Override
	public void delete(UUID id) {
		log.info("Deleting developer with id {}", id);
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		log.warn("Deleting all developers");
		repository.deleteAll();
	}
}
