package lab1.game.repository;

import lab1.developer.entity.Developer;
import lab1.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IGameRepository extends JpaRepository<Game, UUID> {
	List<Game> findAllByDeveloper(Developer developer);
}
