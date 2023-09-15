package com.example.lab5_20206331.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascotas;

    @ManyToOne
    @JoinColumn(name="Persona_idPersona")
    private Persona persona;
    @Column(name = "nombre_mascota")
    private String nombreMascota;
    private String genero;
    private String edad;
    @Column(name = "fecha_nacimiento")
    private String fechaVencimiento;
    private String vacunado;
    private String desparasitado;

}
