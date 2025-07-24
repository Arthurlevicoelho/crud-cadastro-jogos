package colmeia.com.projeto_colmeia.controller;


import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.ConsoleEntity;
import colmeia.com.projeto_colmeia.model.entity.DesenvolvedorEntity;
import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import colmeia.com.projeto_colmeia.service.ConsoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/console")
public class ConsoleController extends BaseController<ConsoleEntity, UUID> {

    private final ConsoleService consoleService;
    public ConsoleController(ConsoleService service) {
        super(service);
        this.consoleService = service;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> save (@RequestBody @Validated ConsoleEntity consoleEntity) {
        return consoleService.save(consoleEntity);
    }

    @PutMapping
    public ResponseEntity<ResponseModel> put (@RequestBody @Validated ConsoleEntity consoleEntity) {
        return consoleService.put(consoleEntity);
    }
}
