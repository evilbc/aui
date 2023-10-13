package lab1.initialize;

import lab1.developer.entity.Developer;
import lab1.game.dto.GetGameResponse;
import lab1.game.entity.Game;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("{}", 'a' + 1);
		// 2.
		log.info("2:");
		Developer d1 = Developer.builder()
				.id(UUID.randomUUID())
				.name("Square Enix")
				.build();
		Developer d2 = Developer.builder()
				.id(UUID.randomUUID())
				.name("Bioware")
				.build();
		Developer d3 = Developer.builder()
				.id(UUID.randomUUID())
				.name("Bethesda")
				.build();

		Collection<Developer> developers = Arrays.asList(d1, d2, d3);


		Game g1 = Game.builder()
				.name("Life is Strange")
				.price(49.99)
				.developer(d1)
				.build();
		d1.addGame(g1);

		Game g2 = Game.builder()
				.name("Tomb Raider (2013)")
				.price(30)
				.developer(d1)
				.build();
		d1.addGame(g2);

		Game g3 = Game.builder()
				.name("Shadow of Tomb Raider")
				.price(80)
				.developer(d1)
				.build();
		d1.addGame(g3);

		Game g4 = Game.builder()
				.name("Knights of the Old Republic")
				.price(20)
				.developer(d2)
				.build();
		d2.addGame(g4);

		Game g5 = Game.builder()
				.name("Mass Effect Legendary Edition")
				.price(50)
				.developer(d2)
				.build();
		d2.addGame(g5);

		Game g6 = Game.builder()
				.name("Skyrim")
				.price(25.50)
				.developer(d3)
				.build();
		d3.addGame(g6);

		Collection<Game> games = Arrays.asList(g1, g2, g3, g4, g5, g6);
		developers.forEach(d -> {
			log.info("{}", d);
			d.getGames()
					.forEach(g -> log.info("{}", g));
		});

		// 3.
		log.info("3:");
		Set<Game> gameSet = developers.stream()
				.flatMap(d -> d.getGames()
						.stream())
				.collect(Collectors.toSet());
		gameSet.stream()
				.forEach(g -> log.info("{}", g));

		// 4.
		log.info("4:");
		games.stream()
				.filter(g -> g.getPrice() >= 30)
				.sorted(Comparator.comparing(Game::getName))
				.forEach(g -> log.info("{}", g));

		// 5.
		log.info("5:");
		List<GetGameResponse> dtoGames = games.stream()
				.map(g -> GetGameResponse.builder()
						.name(g.getName())
						.price(g.getPrice())
						.developer(g.getDeveloper()
								.getName())
						.build())
				.sorted()
				.toList();
		dtoGames.stream()
				.forEach(g -> log.info("{}", g));

		// 6.
		log.info("6:");
		saveToFile(developers);
		readFromFile().stream()
				.forEach(d -> log.info("{}", d));

		// 7.
		log.info("7:");
		ForkJoinPool pool = new ForkJoinPool(2);
		pool.submit(() -> developers.parallelStream()
						.forEach(this::simulateTask))
				.get();
	}

	@SneakyThrows
	private void saveToFile(Collection<Developer> developers) {
		try (FileOutputStream os = new FileOutputStream("binary.bin");
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(developers);
		}
	}

	@SneakyThrows
	@SuppressWarnings("unchecked")
	private Collection<Developer> readFromFile() {
		try (FileInputStream is = new FileInputStream("binary.bin");
				ObjectInputStream ois = new ObjectInputStream(is)) {
			return (Collection<Developer>) ois.readObject();
		}
	}

	@SneakyThrows
	private void simulateTask(Developer dev) {
		for (Game game : dev.getGames()) {
			Thread.sleep(3000);
			log.info("{} -> {}", dev, game);
		}
	}
}
