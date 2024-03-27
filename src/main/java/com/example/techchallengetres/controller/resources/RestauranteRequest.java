package com.example.techchallengetres.controller.resources;

import com.example.techchallengetres.entity.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestauranteRequest {

    @NotNull
    private String nome;
    @NotNull
    private String localizacao;
    @NotNull
    private Tipo tipo;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    private String horarioAbertura;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm")
    private String horarioEncerramento;
    @NotNull
    private int capacidade;

}
