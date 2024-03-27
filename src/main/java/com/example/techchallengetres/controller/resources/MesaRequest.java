package com.example.techchallengetres.controller.resources;

import com.example.techchallengetres.entity.enums.Status;
import com.example.techchallengetres.entity.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class MesaRequest {

    @NotNull
    private int numeroMesa;
    @NotNull
    private UUID idRestaurante;
    @NotNull
    private Status status;


}
