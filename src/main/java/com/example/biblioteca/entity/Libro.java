package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Evita definir los getters y setters
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se generará de forma automática
    private Long id;

    @Column(nullable = false) //Al ponerlo a posterior, hay que modificar la propiedad dll
    private String titulo;

    @Column
    private String autor;
}
