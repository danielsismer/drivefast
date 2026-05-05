package com.drive.fast.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lease")
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dias;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Vehicle veiculo;

    public static Lease create(Integer dias, Client client, Vehicle vehicle) {
        Lease lease = new Lease();
        lease.dias = dias;
        lease.cliente = client;
        lease.veiculo = vehicle;
        lease.recalculateTotal();
        return lease;
    }

    public void update(Integer dias, Client client, Vehicle vehicle) {
        if (dias != null) {
            this.dias = dias;
        }

        if (client != null) {
            this.cliente = client;
        }

        if (vehicle != null) {
            this.veiculo = vehicle;
        }

        recalculateTotal();
    }

    private void recalculateTotal() {
        this.valorTotal = this.veiculo.getValorDiaria()
                .multiply(BigDecimal.valueOf(this.dias));
    }


}
