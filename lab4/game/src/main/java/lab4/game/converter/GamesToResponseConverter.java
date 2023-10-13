package lab4.game.converter;

import lab4.game.dto.GetGamesResponse;
import lab4.game.entity.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class GamesToResponseConverter implements Function<List<Game>, GetGamesResponse> {
	@Override
	public GetGamesResponse apply(List<Game> games) {
		return GetGamesResponse.builder()
				.games(games.stream()
						.map(g -> GetGamesResponse.Game.builder()
								.id(g.getId())
								.name(g.getName())
								.build())
						.toList())
				.build();
	}
}
