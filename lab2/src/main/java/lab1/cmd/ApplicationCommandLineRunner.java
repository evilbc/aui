package lab1.cmd;

import com.fasterxml.jackson.databind.ObjectWriter;
import lab1.developer.entity.Developer;
import lab1.developer.service.api.IDeveloperService;
import lab1.game.entity.Game;
import lab1.game.service.api.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {
	private final ObjectWriter objectWriter;
	private final IDeveloperService developerService;
	private final IGameService gameService;

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String command;
		boolean shouldBreak = false;
		System.out.println("Use help command to list all commands");
		while (!shouldBreak) {
			command = scanner.next();
			switch (command) {
			case "get_developers" -> System.out.println(objectWriter.writeValueAsString(developerService.findAll()));
			case "get_games" -> System.out.println(objectWriter.writeValueAsString(gameService.findAll()));
			case "get_developer_games" -> {
				System.out.println("Developer id: ");
				UUID uuid = UUID.fromString(scanner.next());
				System.out.println(objectWriter.writeValueAsString(gameService.findAllByDeveloper(uuid)
						.orElse(Collections.emptyList())));
			}
			case "delete_game" -> {
				System.out.println("Game id: ");
				UUID id = UUID.fromString(scanner.next());
				gameService.delete(id);
			}
			case "create_game" -> {
				UUID id = UUID.randomUUID();
				System.out.println("Name: ");
				String name = scanner.next();
				System.out.println("Price: ");
				double price = scanner.nextDouble();
				System.out.println("Developer id: ");
				UUID developerId = UUID.fromString(scanner.next());
				Optional<Developer> developer = developerService.find(developerId);
				if (developer.isEmpty()) {
					System.out.println("Developer not found");
					break;
				}
				Game game = Game.builder()
						.id(id)
						.name(name)
						.price(price)
						.developer(developer.get())
						.build();
				gameService.create(game);
				System.out.println(objectWriter.writeValueAsString(game));
			}
			case "help" -> {
				System.out.println("get_developers - prints all developers");
				System.out.println("get_games - prints all games");
				System.out.println("get_developer_games - prints all games made by a developer");
				System.out.println("delete_game - delete a game");
				System.out.println("create_game - create a game");
				System.out.println("help - print all commands");
				System.out.println("quit - shut down the app");
			}
			case "quit" -> shouldBreak = true;
			}
		}
	}
}
