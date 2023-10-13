package lab3.game.converter;

import lab3.developer.entity.Developer;
import lab3.game.dto.GetGameResponse;
import lab3.game.entity.Game;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GameToResponseConverter implements Function<Game, GetGameResponse> {
	@Override
	public GetGameResponse apply(Game game) {
		Developer developer = game.getDeveloper();
		return GetGameResponse.builder()
				.id(game.getId())
				.name(game.getName())
				.price(game.getPrice())
				.year(game.getYear())
				.developer(GetGameResponse.Developer.builder()
						.id(developer.getId())
						.name(developer.getName())
						.build())
				.build();
	}
}
