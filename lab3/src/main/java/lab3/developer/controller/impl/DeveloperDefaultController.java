package lab3.developer.controller.impl;

import lab3.developer.controller.api.IDeveloperController;
import lab3.developer.converter.DeveloperToResponseConverter;
import lab3.developer.converter.DevelopersToResponseConverter;
import lab3.developer.converter.RequestToDeveloperConverter;
import lab3.developer.converter.UpdateDeveloperConverter;
import lab3.developer.dto.GetDeveloperResponse;
import lab3.developer.dto.GetDevelopersResponse;
import lab3.developer.dto.PatchDeveloperRequest;
import lab3.developer.dto.PutDeveloperRequest;
import lab3.developer.entity.Developer;
import lab3.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class DeveloperDefaultController implements IDeveloperController {
	private final IDeveloperService service;
	private final DevelopersToResponseConverter developersToResponseConverter;
	private final DeveloperToResponseConverter developerToResponseConverter;
	private final RequestToDeveloperConverter requestToDeveloperConverter;
	private final UpdateDeveloperConverter updateDeveloperConverter;

	@Override
	public GetDevelopersResponse getDevelopers() {
		return developersToResponseConverter.apply(service.findAll());
	}

	@Override
	public GetDeveloperResponse getDeveloper(UUID id) {
		return service.find(id)
				.map(developerToResponseConverter)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	@Override
	public void putDeveloper(UUID id, PutDeveloperRequest request) {
		service.create(requestToDeveloperConverter.apply(id, request));
	}

	@Override
	public void patchDeveloper(UUID id, PatchDeveloperRequest request) {
		Developer developer = service.find(id)
				.map(g -> updateDeveloperConverter.apply(g, request))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.update(developer);
	}

	@Override
	public void deleteDeveloper(UUID id) {
		Developer developer = service.find(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.delete(developer.getId());
	}
}
