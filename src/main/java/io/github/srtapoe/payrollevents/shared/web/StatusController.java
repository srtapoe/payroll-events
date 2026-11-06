package io.github.srtapoe.payrollevents.shared.web;

import java.time.Instant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint simples para conferir que a API subiu (e para o Swagger ter algo a mostrar no dia 1).
 * Para health check "de verdade", use /actuator/health.
 */
@RestController
@RequestMapping("/api/v1/status")
@Tag(name = "Status")
public class StatusController {

    private final String appName;

    public StatusController(@Value("${spring.application.name}") String appName) {
        this.appName = appName;
    }

    @GetMapping
    @Operation(summary = "Retorna o status da aplicação")
    public StatusResponse status() {
        return new StatusResponse(appName, "UP", Instant.now());
    }

    public record StatusResponse(String application, String status, Instant timestamp) {
    }
}
