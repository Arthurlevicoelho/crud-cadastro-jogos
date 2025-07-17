package colmeia.com.projeto_colmeia.repository;

import colmeia.com.projeto_colmeia.model.entity.DesenvolvedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DesenvolvedorRepository extends JpaRepository<DesenvolvedorEntity, UUID> {
}
