package lab3.developer.converter;

import lab3.developer.dto.PutDeveloperRequest;
import lab3.developer.entity.Developer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToDeveloperConverter implements BiFunction<UUID, PutDeveloperRequest, Developer> {
	@Override
	public Developer apply(UUID id, PutDeveloperRequest request) {
		return Developer.builder()
				.id(id)
				.name(request.getName())
				.country(request.getCountry())
				.build();
	}
}
