package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.entity.UsuarioEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController<UsuarioEntity, UUID> {
    public UsuarioController(BaseService<UsuarioEntity, UUID> service) {
        super(service);
    }
}
