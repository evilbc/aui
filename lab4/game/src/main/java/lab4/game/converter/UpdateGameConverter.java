package lab4.game.converter;

import lab4.game.dto.PatchGameRequest;
import lab4.game.entity.Game;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateGameConverter implements BiFunction<Game, PatchGameRequest, Game> {
	@Override
	public Game apply(Game game, PatchGameRequest request) {
		return Game.builder()
				.id(game.getId())
				.name(request.getName())
				.price(request.getPrice())
				.year(request.getYear())
				.developer(game.getDeveloper())
				.build();
	}
}
