package colmeia.com.projeto_colmeia.repository;

import colmeia.com.projeto_colmeia.model.entity.ConsoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsoleRepository extends JpaRepository<ConsoleEntity, UUID> {
}
