package com.example.biblioteca;

import com.example.biblioteca.controller.LibroController;
import com.example.biblioteca.entity.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class LibroControllerTest {

    @Autowired
    private LibroController libroController;

    @Test
    void testGetLibro() {
        Optional<Libro> libro = libroController.getLibro(1L);
        assertFalse(libro.isEmpty());
    }
}
