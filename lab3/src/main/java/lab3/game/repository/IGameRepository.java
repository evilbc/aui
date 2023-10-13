package lab3.game.repository;

import lab3.developer.entity.Developer;
import lab3.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IGameRepository extends JpaRepository<Game, UUID> {
	List<Game> findAllByDeveloper(Developer developer);
}
