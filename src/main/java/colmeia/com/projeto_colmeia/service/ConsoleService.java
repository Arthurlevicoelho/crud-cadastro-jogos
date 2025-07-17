package colmeia.com.projeto_colmeia.service;


import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.ConsoleEntity;
import colmeia.com.projeto_colmeia.repository.ConsoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsoleService extends BaseService<ConsoleEntity, UUID> {

    private final ConsoleRepository consoleRepository;

    public ConsoleService( ConsoleRepository consoleRepository) {
        super(consoleRepository);
        this.consoleRepository = consoleRepository;
    }

    private ResponseEntity<ResponseModel> save(ConsoleEntity console) {
        if (console != null) {
            ConsoleEntity consoleEntity = consoleRepository.getReferenceById(console.getId());

            if (consoleEntity == null) {

                consoleRepository.save(console);
                return ResponseEntity.ok().body(new ResponseModel(null, "Console cadastrado"));
            }else {
                return ResponseEntity.badRequest().body(new ResponseModel(null, "Console já cadastrado"));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseModel(null, "Console inválido"));
    }

    public ResponseEntity<ResponseModel> put(ConsoleEntity consoleEntity) {
        if (consoleEntity != null && consoleEntity.getId() != null) {
            ConsoleEntity console = consoleRepository.getReferenceById(consoleEntity.getId());

            if (console == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Console não localizado"));
            if (console != null && !console.getNome().equals(console.getNome())) return ResponseEntity.badRequest().body(new ResponseModel(null, "Nome de console já utilizado"));

            consoleRepository.save(consoleEntity);

            return ResponseEntity.ok().body(new ResponseModel(null, "Console atualizado"));
        }

        return ResponseEntity.badRequest().body(new ResponseModel(null, "Console inválido"));
    }
}
