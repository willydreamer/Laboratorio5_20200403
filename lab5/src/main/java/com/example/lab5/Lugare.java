package com.example.lab5;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lugares")
public class Lugare {
    @Id
    @Column(name = "idLugares", nullable = false)
    private Integer id;

    @Column(name = "nombre_lugar", length = 45)
    private String nombreLugar;

    @Column(name = "descrip_lugar", length = 45)
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private LocalDate fechaLugar;

}