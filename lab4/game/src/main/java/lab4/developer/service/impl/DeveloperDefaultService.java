package lab4.developer.service.impl;

import lab4.developer.entity.Developer;
import lab4.developer.repository.IDeveloperRepository;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
	public void create(Developer developer) {
		repository.save(developer);
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
}
