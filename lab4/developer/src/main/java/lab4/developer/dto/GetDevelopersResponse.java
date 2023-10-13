package lab4.developer.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDevelopersResponse {
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Developer {
		private UUID id;
		private String name;
	}

	@Singular
	private List<Developer> developers;

}
