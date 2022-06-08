package com.rflpazini.alticci;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Alticci sequence",
                version = "1.0",
                description = "API that determine a number in a specific sequence",
                contact = @Contact(url = "https://rflpazini.com", name = "Rafael Pazini")))
public class AlticciApplication {

    public static void main(String[] args) {
        Micronaut.run(AlticciApplication.class, args);
    }
}
