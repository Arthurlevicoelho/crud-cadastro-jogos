package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.entity.GeneroEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/genero")
public class GeneroController extends BaseController<GeneroEntity, UUID> {
    public GeneroController(BaseService<GeneroEntity, UUID> service) {
        super(service);
    }
}
