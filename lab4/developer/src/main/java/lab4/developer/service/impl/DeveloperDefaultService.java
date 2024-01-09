package lab4.developer.service.impl;

import lab4.developer.entity.Developer;
import lab4.developer.event.repository.api.IDeveloperEventRepository;
import lab4.developer.repository.IDeveloperRepository;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class DeveloperDefaultService implements IDeveloperService {
	private final IDeveloperRepository repository;
	private final IDeveloperEventRepository eventRepository;

	@Override
	public Optional<Developer> find(UUID id) {
		log.info("Finding developer with id {}", id);
		return repository.findById(id);
	}

	@Override
	public List<Developer> findAll() {
		log.info("Finding all developers");
		return repository.findAll();
	}

	@Override
	@Transactional
	public void create(Developer developer) {
		log.info("Creating developer {}", developer);
		repository.save(developer);
		eventRepository.create(developer.getId());
	}

	@Override
	public void update(Developer developer) {
		log.info("Updating developer {}", developer);
		repository.save(developer);
	}

	@Override
	@Transactional
	public void delete(UUID id) {
		log.info("Deleting developer with id {}", id);
		repository.deleteById(id);
		eventRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		log.warn("Deleting all developers");
		findAll().forEach(dev -> delete(dev.getId()));
	}
}
