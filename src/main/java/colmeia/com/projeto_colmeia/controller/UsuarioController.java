package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.model.entity.UsuarioEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import colmeia.com.projeto_colmeia.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<UsuarioEntity, UUID> {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService service) {
        super(service);
        this.usuarioService = service;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> save (@RequestBody @Validated UsuarioEntity usuarioEntity) {
        return usuarioService.save(usuarioEntity);
    }

    @PutMapping
    public ResponseEntity<ResponseModel> put (@RequestBody @Validated UsuarioEntity usuarioEntity) {
        return usuarioService.put(usuarioEntity);
    }
}
