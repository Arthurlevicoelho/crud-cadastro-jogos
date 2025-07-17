package colmeia.com.projeto_colmeia.repository;

import colmeia.com.projeto_colmeia.model.entity.JogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogoRepository extends JpaRepository<JogoEntity, UUID> {
}
