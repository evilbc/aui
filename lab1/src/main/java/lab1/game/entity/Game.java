package lab1.game.entity;

import lab1.developer.entity.Developer;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
	private String name;
	private double price;
	private Developer developer;

}
