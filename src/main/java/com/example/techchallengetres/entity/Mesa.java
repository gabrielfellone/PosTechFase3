package com.example.techchallengetres.entity;

import com.example.techchallengetres.controller.resources.MesaRequest;
import com.example.techchallengetres.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("mesa")
public class Mesa {

    @Column
    @PrimaryKey
    private int numeroMesa;
    private UUID idRestaurante;
    private Status status;
    private String diaReserva;
    private String horaReserva;

    public Mesa(Optional<Mesa> mesa) {
        if (mesa.isPresent()) {
            this.numeroMesa = mesa.get().getNumeroMesa();
            this.idRestaurante = mesa.get().getIdRestaurante();
            this.status = mesa.get().getStatus();
            this.diaReserva = mesa.get().getDiaReserva();
            this.horaReserva = mesa.get().getHoraReserva();
        }
    }

    public Mesa(MesaRequest request) {
        this.numeroMesa = request.getNumeroMesa();
        this.idRestaurante = request.getIdRestaurante();
        this.status = request.getStatus();
    }
}
