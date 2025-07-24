package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.DesenvolvedorEntity;
import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import colmeia.com.projeto_colmeia.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/genero")
public class GeneroController extends BaseController<GeneroEntity, UUID> {


    private final GeneroService service;

    public GeneroController(GeneroService service) {
        super(service);
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> save (@RequestBody @Validated GeneroEntity generoEntity) {
        return service.save(generoEntity);
    }

    @PutMapping
    public ResponseEntity<ResponseModel> put (@RequestBody @Validated GeneroEntity generoEntity) {
        return service.put(generoEntity);
    }
}
