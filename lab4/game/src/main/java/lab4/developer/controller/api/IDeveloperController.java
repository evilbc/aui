package lab4.developer.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface IDeveloperController {

	@PutMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	void putDeveloper(@PathVariable("id") UUID id);

	@DeleteMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	void deleteDeveloper(@PathVariable("id") UUID id);

}
