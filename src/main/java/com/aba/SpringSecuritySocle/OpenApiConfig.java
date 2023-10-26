package com.aba.SpringSecuritySocle;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Abdeljabar",
                        email = "aitbelkhalil@gmail.com"
                ),
                description = "Todo App Api Documentation",
                title = "API DOC - todo app",
                version = "1.0"

        ),
        servers = {
                @Server(
                        description = "local env",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "prod env",
                        url = "http://localhost:8080"
                )
        }

)
public class OpenApiConfig {
}
