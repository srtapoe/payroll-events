package io.github.srtapoe.payrollevents.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI payrollEventsOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Payroll Events API")
                .description("Eventos de folha de pagamento (admissão, férias, consignado) publicados em mensageria.")
                .version("v1")
                .contact(new Contact().name("Joanice Oliveira").url("https://github.com/srtapoe"))
                .license(new License().name("MIT")));
    }
}
