package com.vehiculo_bbdd.VehiculoDB.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "id_vehiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehiculo;

    @Column(name = "tipo_vehiculo")
    String tipo;

    @Column(name = "marca")
    String marca;

    @Column(name = "potencia")
    Integer potencia;

    @Column(name = "fecha_compra")
    Date fechaCompra;

}
