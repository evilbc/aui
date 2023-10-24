package lab2.developer.repository;

import lab2.developer.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDeveloperRepository extends JpaRepository<Developer, UUID> {
}
