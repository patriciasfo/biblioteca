package com.example.biblioteca;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BienvenidaController {

    @GetMapping
    public String bienvenida() {
        String saludo = "Bienvenid@ al IES Monte Naranco!! a todos";
        String release = "Mensaje nuevo para la releas";
        return "Bienvenid@ al IES Monte Naranco!! a todos \n Añado para forzar análisis de sonar";
    }
}
