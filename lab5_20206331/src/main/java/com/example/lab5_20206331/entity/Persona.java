package com.example.lab5_20206331.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    private String dni;
    private String nombre;
    private String celular;
    @Column(name = "tipo_persona")
    private String tipoPersona;


}
