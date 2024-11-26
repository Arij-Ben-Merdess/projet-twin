package tn.esprit.projettwin;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().servers(
                List.of(new Server().url("http://localhost:8089/tpfoyer").description("Serveur local"),
                        new Server().url("http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs").description("Afiicher tous les blocs"),
                        new Server().url("http://localhost:8089/tpfoyer/bloc//retrieve-bloc/{bloc-id}"))
                ).tags
                (List.of(
                new Tag().name("Gestion Blocs").description("Endpoints pour la gestion des blocs"),
                new Tag().name("Gestion Chambres").description("Endpoints pour la gestion des chambres")
                ));

    }
}
