package lab4.developer.entity;

import jakarta.persistence.*;
import lab4.game.entity.Game;
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
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "developer", cascade = CascadeType.REMOVE)
	private List<Game> games = new ArrayList<>();

}
