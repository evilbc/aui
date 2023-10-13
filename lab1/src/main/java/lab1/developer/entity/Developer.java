package lab1.developer.entity;

import lab1.game.entity.Game;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Developer implements Serializable {
	private UUID id;
	private String name;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private transient List<Game> games = new ArrayList<>();

	@ToString.Include
	private int gamesCount() {
		return games == null ? 0 : games.size();
	}
	public void addGame(Game game) {
		games.add(game);
	}
}
