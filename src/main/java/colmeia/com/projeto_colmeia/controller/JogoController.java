package colmeia.com.projeto_colmeia.controller;

import colmeia.com.projeto_colmeia.model.entity.JogoEntity;
import colmeia.com.projeto_colmeia.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/jogo")
public class JogoController extends BaseController<JogoEntity, UUID> {


    public JogoController(BaseService<JogoEntity, UUID> service) {
        super(service);
    }
}
