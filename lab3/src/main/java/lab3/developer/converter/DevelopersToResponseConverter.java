package lab3.developer.converter;

import lab3.developer.dto.GetDevelopersResponse;
import lab3.developer.entity.Developer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class DevelopersToResponseConverter implements Function<List<Developer>, GetDevelopersResponse> {
	@Override
	public GetDevelopersResponse apply(List<Developer> developers) {
		return GetDevelopersResponse.builder()
				.developers(developers.stream()
						.map(d -> GetDevelopersResponse.Developer.builder()
								.id(d.getId())
								.name(d.getName())
								.build())
						.toList())
				.build();
	}
}
