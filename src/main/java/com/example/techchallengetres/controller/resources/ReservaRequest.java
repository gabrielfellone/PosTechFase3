package com.example.techchallengetres.controller.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ReservaRequest {

    @NotNull
    private int idUsuario;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private String diaReserva;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    private String horaReserva;
    @NotNull
    private UUID idRestaurante;

}
