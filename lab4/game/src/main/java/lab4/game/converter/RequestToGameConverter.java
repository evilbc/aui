package lab4.game.converter;

import lab4.developer.entity.Developer;
import lab4.game.dto.PutGameRequest;
import lab4.game.entity.Game;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToGameConverter implements BiFunction<UUID, PutGameRequest, Game> {
	@Override
	public Game apply(UUID id, PutGameRequest request) {
		return Game.builder()
				.id(id)
				.name(request.getName())
				.price(request.getPrice())
				.year(request.getYear())
				.developer(Developer.builder()
						.id(request.getDeveloperId())
						.build())
				.build();
	}
}
