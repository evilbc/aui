package lab3.developer.controller.api;

import lab3.developer.dto.GetDeveloperResponse;
import lab3.developer.dto.GetDevelopersResponse;
import lab3.developer.dto.PatchDeveloperRequest;
import lab3.developer.dto.PutDeveloperRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface IDeveloperController {
	@GetMapping("api/developers")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetDevelopersResponse getDevelopers();

	@GetMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetDeveloperResponse getDeveloper(@PathVariable("id") UUID id);

	@PutMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	void putDeveloper(@PathVariable("id") UUID id, @RequestBody PutDeveloperRequest request);

	@PatchMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	void patchDeveloper(@PathVariable("id") UUID id, @RequestBody PatchDeveloperRequest request);

	@DeleteMapping("/api/developers/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	void deleteDeveloper(@PathVariable("id") UUID id);

}
