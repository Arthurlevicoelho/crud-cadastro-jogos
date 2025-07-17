package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.ResponseModel;
import colmeia.com.projeto_colmeia.model.entity.DesenvolvedorEntity;
import colmeia.com.projeto_colmeia.service.DesenvolvedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/desenvolvedor")
public class DesenvolvedorController extends BaseController<DesenvolvedorEntity, UUID> {

    private final DesenvolvedorService desenvolvedorService;
    public DesenvolvedorController(DesenvolvedorService desenvolvedorService) {
        super(desenvolvedorService);
        this.desenvolvedorService = desenvolvedorService;
    }

    @PostMapping
    public ResponseEntity<ResponseModel> save (@RequestBody @Validated DesenvolvedorEntity desenvolvedor) {
        return desenvolvedorService.save(desenvolvedor);
    }

    @PutMapping
    public ResponseEntity<ResponseModel> put (@RequestBody @Validated DesenvolvedorEntity desenvolvedorEntity) {
        return desenvolvedorService.put(desenvolvedorEntity);
    }
}
