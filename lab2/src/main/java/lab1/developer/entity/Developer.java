package lab1.developer.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "developers")
public class Developer implements Serializable {
	@Id
	private UUID id;
	@Column(name = "developer_name", nullable = false)
	private String name;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "developer", fetch = FetchType.LAZY)
	private transient List<Game> games = new ArrayList<>();

	@ToString.Include
	private int gamesCount() {
		return games == null ? 0 : games.size();
	}

	public void addGame(Game game) {
		games.add(game);
	}
}
