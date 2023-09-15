package com.example.lab5_20206331.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "viajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViajes;
    @Column(name = "punto_recojo")
    private String puntoRecojo;
    @Column(name = "cant_personas")
    private String cantPersonas;
    @Column(name = "cant_perros")
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name="Lugares_idLugares")
    private Lugar lugar;

    @ManyToOne
    @JoinColumn(name="Persona_idPersona")
    private Persona persona;


}

