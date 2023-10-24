package lab2.developer.repository;

import lab2.developer.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer, UUID> {
}
