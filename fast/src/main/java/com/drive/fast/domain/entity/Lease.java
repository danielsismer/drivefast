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
        lease.veiculo.setDisponivel(false);
        lease.recalculateTotal();
        return lease;
    }

    public void update(Integer dias, Client client, Vehicle vehicle) {
        if (vehicle != null && !vehicle.equals(this.veiculo)) {
            this.veiculo = vehicle;
            this.veiculo.setDisponivel(false);
        }

        if (dias != null) this.dias = dias;
        if (client != null) this.cliente = client;

        recalculateTotal();
    }

    public void cancel() {
        this.veiculo.setDisponivel(true);
    }

    private void recalculateTotal() {
        if (this.veiculo != null && this.dias != null) {
            this.valorTotal = this.veiculo.getValorDiaria()
                    .multiply(BigDecimal.valueOf(this.dias));
        }
    }
}