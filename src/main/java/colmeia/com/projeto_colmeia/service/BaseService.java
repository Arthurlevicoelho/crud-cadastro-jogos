package colmeia.com.projeto_colmeia.service;

import java.io.Serializable;
import java.util.UUID;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService <T, ID extends Serializable> {

    private final JpaRepository<T, UUID> repository;

    public BaseService(JpaRepository<T, UUID> repository) {
        this.repository = repository;
    }

    public ResponseEntity<ResponseModel> getAll(int page, int size) {
        return ResponseEntity.ok().body(new ResponseModel(repository.findAll(PageRequest.of(page, size)), ""));
    }

    public ResponseEntity<ResponseModel> get(UUID id) {
        if (id == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Id não enviado"));

        return ResponseEntity.ok().body(new ResponseModel(repository.findById(id).get(), ""));
    };

    public ResponseEntity<ResponseModel> delete(UUID id) {
        if (id == null) return ResponseEntity.badRequest().body(new ResponseModel(null, "Id não enviado"));

        repository.deleteById(id);

        return ResponseEntity.ok().body(new ResponseModel(null, "Removido com sucesso"));
    };

}
