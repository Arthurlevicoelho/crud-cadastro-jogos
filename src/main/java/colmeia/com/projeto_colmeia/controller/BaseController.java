package colmeia.com.projeto_colmeia.controller;


import java.io.Serializable;
import java.util.UUID;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.constraints.NotNull;

@RestController
public abstract class BaseController<T, ID extends Serializable> {

    private final BaseService<T, UUID> service;

    public BaseController(BaseService<T, UUID> service) {
        this.service = service;
    }

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<ResponseModel> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        // return ResponseEntity.ok().body(new ResponseModel(repository.findAll(PageRequest.of(page, size)), null));
        return service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> get(@PathVariable @NotNull UUID id) {
        return service.get(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable @NotNull UUID id) {
        return service.delete(id);
    }

}
