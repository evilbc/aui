package lab3.game.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetGamesResponse {
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Game {
		private UUID id;
		private String name;
	}

	@Singular
	private List<Game> games;

}
