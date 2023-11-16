package lab4.developer.initialize;

import lab4.developer.entity.Developer;
import lab4.developer.service.api.IDeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer implements InitializingBean {
	private final IDeveloperService developerService;

	@Value("${lab4.db.restart}")
	private boolean restart;
	@Override
	public void afterPropertiesSet() {
		if (!developerService.findAll().isEmpty() && !restart) {
			return;
		} else if (restart) {
			developerService.deleteAll();
		}
		Developer squareEnix = Developer.builder()
				.id(UUID.fromString("8a991143-36ee-4d22-bdf6-c9dc301576ee"))
				.name("Square Enix")
				.country("JP")
				.build();
		Developer bioware = Developer.builder()
				.id(UUID.fromString("3d82fb9a-77a1-48a2-ae12-e78488a28114"))
				.name("Bioware")
				.country("CA")
				.build();
		Developer bethesda = Developer.builder()
				.id(UUID.fromString("61997695-cb9d-41b2-96c3-c28df27783e4"))
				.name("Bethesda")
				.country("US")
				.build();

		for (Developer dev : Arrays.asList(squareEnix, bioware, bethesda)) {
			developerService.create(dev);
		}

	}
}
