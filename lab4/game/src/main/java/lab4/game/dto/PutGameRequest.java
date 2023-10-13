package lab4.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutGameRequest {
	private String name;
	private Double price;
	private Integer year;
	private UUID developerId;

}
