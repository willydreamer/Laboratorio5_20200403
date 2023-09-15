package com.example.lab5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lugares")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares", nullable = false)
    private Integer id;

    @Column(name = "nombre_lugar", length = 45)
    private String nombreLugar;

    @Column(name = "descrip_lugar", length = 45)
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private LocalDate fechaLugar;

}
