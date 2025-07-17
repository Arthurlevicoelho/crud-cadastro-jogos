package colmeia.com.projeto_colmeia.repository;

import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneroRepository extends JpaRepository<GeneroEntity, UUID> {
}
