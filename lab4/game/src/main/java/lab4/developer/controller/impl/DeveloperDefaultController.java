package lab4.developer.controller.impl;

import lab4.developer.controller.api.IDeveloperController;
import lab4.developer.entity.Developer;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class DeveloperDefaultController implements IDeveloperController {
	private final IDeveloperService service;

	@Override
	public void putDeveloper(UUID id) {
		service.create(Developer.builder()
				.id(id)
				.build());
	}

	@Override
	public void deleteDeveloper(UUID id) {
		Developer developer = service.find(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.delete(developer.getId());
	}
}
