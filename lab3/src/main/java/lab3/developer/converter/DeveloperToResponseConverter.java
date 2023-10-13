package lab3.developer.converter;

import lab3.developer.dto.GetDeveloperResponse;
import lab3.developer.entity.Developer;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeveloperToResponseConverter implements Function<Developer, GetDeveloperResponse> {
	@Override
	public GetDeveloperResponse apply(Developer developer) {
		return GetDeveloperResponse.builder()
				.id(developer.getId())
				.name(developer.getName())
				.country(developer.getCountry())
				.build();
	}
}
