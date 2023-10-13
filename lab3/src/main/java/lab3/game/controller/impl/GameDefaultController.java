package lab3.game.controller.impl;

import lab3.game.controller.api.IGameController;
import lab3.game.converter.GameToResponseConverter;
import lab3.game.converter.GamesToResponseConverter;
import lab3.game.converter.RequestToGameConverter;
import lab3.game.converter.UpdateGameConverter;
import lab3.game.dto.GetGameResponse;
import lab3.game.dto.GetGamesResponse;
import lab3.game.dto.PatchGameRequest;
import lab3.game.dto.PutGameRequest;
import lab3.game.entity.Game;
import lab3.game.service.api.IGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@RestController
public class GameDefaultController implements IGameController {
	private final IGameService service;
	private final GamesToResponseConverter gamesToResponseConverter;
	private final GameToResponseConverter gameToResponseConverter;
	private final RequestToGameConverter requestToGameConverter;
	private final UpdateGameConverter updateGameConverter;

	@Override
	public GetGamesResponse getGames() {
		return gamesToResponseConverter.apply(service.findAll());
	}

	@Override
	public GetGamesResponse getDeveloperGames(UUID developerId) {
		return service.findAllByDeveloper(developerId)
				.map(gamesToResponseConverter)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public GetGameResponse getGame(UUID id) {
		return service.find(id)
				.map(gameToResponseConverter)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void putGame(UUID id, PutGameRequest request) {
		service.create(requestToGameConverter.apply(id, request));
	}

	@Override
	public void patchGame(UUID id, PatchGameRequest request) {
		Game game = service.find(id)
				.map(g -> updateGameConverter.apply(g, request))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.update(game);
	}

	@Override
	public void deleteGame(UUID id) {
		Game game = service.find(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		service.delete(game.getId());
	}
}
