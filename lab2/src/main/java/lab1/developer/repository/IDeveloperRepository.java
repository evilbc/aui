package lab1.developer.repository;

import lab1.developer.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDeveloperRepository extends JpaRepository<Developer, UUID> {
}
