package colmeia.com.projeto_colmeia.repository;

import colmeia.com.projeto_colmeia.model.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    UsuarioEntity findByEmail(String email);

}
