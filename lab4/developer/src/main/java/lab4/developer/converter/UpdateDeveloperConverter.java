package lab4.developer.converter;

import lab4.developer.dto.PatchDeveloperRequest;
import lab4.developer.entity.Developer;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateDeveloperConverter implements BiFunction<Developer, PatchDeveloperRequest, Developer> {
	@Override
	public Developer apply(Developer developer, PatchDeveloperRequest request) {
		return Developer.builder()
				.id(developer.getId())
				.name(request.getName())
				.country(request.getCountry())
				.build();
	}
}
