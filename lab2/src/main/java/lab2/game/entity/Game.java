package lab2.game.entity;

import jakarta.persistence.*;
import lab2.developer.entity.Developer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game implements Serializable {
	@Id
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "developer")
	private Developer developer;

}
