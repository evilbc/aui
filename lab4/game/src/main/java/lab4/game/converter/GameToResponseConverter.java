package lab4.game.converter;

import lab4.game.dto.GetGameResponse;
import lab4.game.entity.Game;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GameToResponseConverter implements Function<Game, GetGameResponse> {
	@Override
	public GetGameResponse apply(Game game) {
		return GetGameResponse.builder()
				.id(game.getId())
				.name(game.getName())
				.price(game.getPrice())
				.year(game.getYear())
				.developerId(game.getDeveloper()
						.getId())
				.build();
	}
}
