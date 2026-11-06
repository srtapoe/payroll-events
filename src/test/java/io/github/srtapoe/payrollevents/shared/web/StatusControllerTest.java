package io.github.srtapoe.payrollevents.shared.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Teste de fatia web: sobe só a camada MVC (sem banco), então roda rápido e sem Docker.
 * Testes com banco de verdade entram na semana 5 (Testcontainers).
 */
@WebMvcTest(StatusController.class)
@TestPropertySource(properties = "spring.application.name=payroll-events")
class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarStatusUp() throws Exception {
        mockMvc.perform(get("/api/v1/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application").value("payroll-events"))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
