package lab3.developer.service.impl;

import lab3.developer.entity.Developer;
import lab3.developer.repository.IDeveloperRepository;
import lab3.developer.service.api.IDeveloperService;
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

	@Override
	public void update(Developer developer) {
		repository.save(developer);
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}
}
