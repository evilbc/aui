package lab4.developer.service.impl;

import lab4.developer.entity.Developer;
import lab4.developer.event.repository.api.IDeveloperEventRepository;
import lab4.developer.repository.IDeveloperRepository;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeveloperDefaultService implements IDeveloperService {
	private final IDeveloperRepository repository;
	private final IDeveloperEventRepository eventRepository;

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
		eventRepository.create(developer.getId());
	}

	@Override
	public void update(Developer developer) {
		repository.save(developer);
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
		eventRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		findAll().forEach(dev -> delete(dev.getId()));
	}
}
