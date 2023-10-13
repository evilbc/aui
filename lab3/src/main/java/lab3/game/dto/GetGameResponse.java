package lab3.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetGameResponse {
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Developer {
		private UUID id;
		private String name;
	}

	private UUID id;
	private String name;
	private Double price;
	private Integer year;
	private Developer developer;

}
