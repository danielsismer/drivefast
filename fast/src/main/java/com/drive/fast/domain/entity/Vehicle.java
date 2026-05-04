package com.drive.fast.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/*
● id: Long (Chave Primária)
● marca: String
● modelo: String
● placa: String
● valorDiaria: BigDecimal
● disponivel: Boolean (Por padrão, deve iniciar como true)
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private BigDecimal valorDiaria;

    @Column(nullable = false)
    private boolean disponivel;

    public static Vehicle create(String marca, String modelo, String placa, BigDecimal valorDiaria){
        Vehicle vehicle = new Vehicle();
        vehicle.setMarca(marca);
        vehicle.setModelo(modelo);
        vehicle.setPlaca(placa);
        vehicle.setValorDiaria(valorDiaria);
        vehicle.setDisponivel(true);
        return vehicle;
    }

}
