package com.example.techchallengetres.controller.resources;

import com.example.techchallengetres.entity.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AvaliacaoRequest {
    @NotNull
    private String comentario;
    @NotNull
    private int idUsuario;
    @NotNull
    private int nota;

}
