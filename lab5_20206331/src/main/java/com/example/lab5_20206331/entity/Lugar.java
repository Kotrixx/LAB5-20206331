package com.example.lab5_20206331.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name ="lugares")
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLugares;
    @Column(name = "nombre_lugar")
    private String nombreLugar;
    @Column(name = "descrip_lugar")
    private String descripLugar;
    @Column(name = "fecha_lugar")
    private Date fechaLugar;
}
