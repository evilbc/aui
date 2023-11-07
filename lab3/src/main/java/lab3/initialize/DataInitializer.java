package lab3.initialize;

import lab3.developer.entity.Developer;
import lab3.developer.service.api.IDeveloperService;
import lab3.game.entity.Game;
import lab3.game.service.api.IGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer implements InitializingBean {
	private final IDeveloperService developerService;
	private final IGameService gameService;

	@Override
	public void afterPropertiesSet() {
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

		Game lifeIsStrange = Game.builder()
				.id(UUID.fromString("7fd97a3d-2841-4443-92f3-12fb4237afb9"))
				.name("Life is Strange")
				.price(49.99)
				.developer(squareEnix)
				.build();

		Game tombRaider = Game.builder()
				.id(UUID.fromString("a18e1f5a-0a55-4750-94d2-026f8e41b902"))
				.name("Tomb Raider")
				.price(30D)
				.year(2013)
				.developer(squareEnix)
				.build();

		Game shadowOfTombRaider = Game.builder()
				.id(UUID.fromString("ee274109-2cc7-4f14-b563-565a121742bc"))
				.name("Shadow of Tomb Raider")
				.price(80D)
				.developer(squareEnix)
				.build();

		Game kotor = Game.builder()
				.id(UUID.fromString("5f2e6575-d0be-4b83-b108-83bc35694b19"))
				.name("Knights of the Old Republic")
				.price(20D)
				.developer(bioware)
				.build();

		Game massEffect = Game.builder()
				.id(UUID.fromString("ec5cc957-040c-4a84-b89e-d3b60dfdf093"))
				.name("Mass Effect Legendary Edition")
				.price(50D)
				.developer(bioware)
				.build();

		for (Game game : Arrays.asList(lifeIsStrange, tombRaider, shadowOfTombRaider, kotor, massEffect)) {
			gameService.create(game);
		}

	}
}
