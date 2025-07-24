package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.model.entity.JogoEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import colmeia.com.projeto_colmeia.service.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/jogo")
public class JogoController extends BaseController<JogoEntity, UUID> {

    private final JogoService jogoService;
    public JogoController(JogoService service) {
        super(service);
        this.jogoService = service;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> save (@RequestBody @Validated JogoEntity jogoEntity) {
        return jogoService.save(jogoEntity);
    }

    @PutMapping
    public ResponseEntity<ResponseModel> put (@RequestBody @Validated JogoEntity jogoEntity) {
        return jogoService.put(jogoEntity);
    }
}
