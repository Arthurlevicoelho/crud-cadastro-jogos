package colmeia.com.projeto_colmeia.service;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.UsuarioEntity;
import colmeia.com.projeto_colmeia.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService extends BaseService<UsuarioEntity, UUID> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(JpaRepository<UsuarioEntity, UUID> repository, UsuarioRepository usuarioRepository) {
        super(repository);
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<ResponseModel> save(UsuarioEntity usuarioEntity) {
        if (usuarioEntity != null) {
            UsuarioEntity usuario = usuarioRepository.findByEmail(usuarioEntity.getEmail());

            if (usuario == null) {
                usuarioRepository.save(usuarioEntity);

                return ResponseEntity.ok().body(new ResponseModel(null, "Usuário cadastrado"));
            } else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Email já cadastrado"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null, "Usuário inválido"));
    }

    public ResponseEntity<ResponseModel> put(UsuarioEntity usuarioEntity) {
        if (usuarioEntity != null && usuarioEntity.getId() != null) {
            UsuarioEntity usuario = usuarioRepository.getReferenceById(usuarioEntity.getId());

            if (usuario == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Usuário não localizado"));
            if (usuario != null && !usuario.getNome().equals(usuario.getNome())) return ResponseEntity.badRequest().body(new ResponseModel(null, "Nomde do usuário já utilizado"));

            usuarioRepository.save(usuarioEntity);

            return ResponseEntity.ok().body(new ResponseModel(null, "Usuário atualizado"));
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Usuário inválido"));
    }

}
