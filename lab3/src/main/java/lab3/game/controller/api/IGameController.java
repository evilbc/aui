package lab3.game.controller.api;

import lab3.game.dto.GetGameResponse;
import lab3.game.dto.GetGamesResponse;
import lab3.game.dto.PatchGameRequest;
import lab3.game.dto.PutGameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface IGameController {
	@GetMapping("api/games")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetGamesResponse getGames();

	@GetMapping("/api/developers/{developerId}/games")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetGamesResponse getDeveloperGames(@PathVariable("developerId") UUID developerId);

	@GetMapping("/api/games/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetGameResponse getGame(@PathVariable("id") UUID id);

	@PutMapping("/api/games/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	void putGame(@PathVariable("id") UUID id, @RequestBody PutGameRequest request);

	@PatchMapping("/api/games/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	void patchGame(@PathVariable("id") UUID id, @RequestBody PatchGameRequest request);

	@DeleteMapping("/api/games/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	void deleteGame(@PathVariable("id") UUID id);

}
