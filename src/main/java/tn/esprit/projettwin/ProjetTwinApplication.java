package tn.esprit.projettwin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Mon API Spring Boot",
                version = "1.0",
                description = "Documentation de l'API Swagger "
                ,contact = @Contact(name = "Arij Ben Merdes", url="www.google.com" , email = "arij.benmerdes@gmail.com")
        ))
public class ProjetTwinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetTwinApplication.class, args);
    }

}
