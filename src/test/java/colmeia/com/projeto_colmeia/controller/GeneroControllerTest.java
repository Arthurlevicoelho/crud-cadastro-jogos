package colmeia.com.projeto_colmeia.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deveria devolver codigo 400 quando informações estao invalidas")
    void save_cenario1() throws Exception {

        var response = mockMvc.perform(MockMvcRequestBuilders.post("/genero"))
                .andReturn().getResponse();

        assertEquals(400, response.getStatus());
    }
}