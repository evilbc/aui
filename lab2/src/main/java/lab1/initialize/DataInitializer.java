package lab1.initialize;

import lab1.developer.entity.Developer;
import lab1.developer.service.api.IDeveloperService;
import lab1.game.entity.Game;
import lab1.game.service.api.IGameService;
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
				.id(UUID.randomUUID())
				.name("Square Enix")
				.build();
		Developer bioware = Developer.builder()
				.id(UUID.randomUUID())
				.name("Bioware")
				.build();
		Developer bethesda = Developer.builder()
				.id(UUID.randomUUID())
				.name("Bethesda")
				.build();

		for (Developer dev : Arrays.asList(squareEnix, bioware, bethesda)) {
			developerService.create(dev);
		}

		Game lifeIsStrange = Game.builder()
				.id(UUID.randomUUID())
				.name("Life is Strange")
				.price(49.99)
				.developer(squareEnix)
				.build();

		Game tombRaider = Game.builder()
				.id(UUID.randomUUID())
				.name("Tomb Raider (2013)")
				.price(30)
				.developer(squareEnix)
				.build();

		Game shadowOfTombRaider = Game.builder()
				.id(UUID.randomUUID())
				.name("Shadow of Tomb Raider")
				.price(80)
				.developer(squareEnix)
				.build();

		Game kotor = Game.builder()
				.id(UUID.randomUUID())
				.name("Knights of the Old Republic")
				.price(20)
				.developer(bioware)
				.build();

		Game massEffect = Game.builder()
				.id(UUID.randomUUID())
				.name("Mass Effect Legendary Edition")
				.price(50)
				.developer(bioware)
				.build();

		Game skyrim = Game.builder()
				.id(UUID.randomUUID())
				.name("Skyrim")
				.price(25.50)
				.developer(bethesda)
				.build();

		for (Game game : Arrays.asList(lifeIsStrange, tombRaider, shadowOfTombRaider, kotor, massEffect, skyrim)) {
			gameService.create(game);
		}

	}
}
