package lab2.game.repository;

import lab2.developer.entity.Developer;
import lab2.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IGameRepository extends JpaRepository<Game, UUID> {
	List<Game> findAllByDeveloper(Developer developer);
}
