package com.example.techchallengetres.mother;

import com.example.techchallengetres.controller.resources.RestauranteRequest;

import com.example.techchallengetres.entity.enums.Tipo;
import lombok.Builder;

import java.util.ArrayList;

@Builder
public class RestauranteRequestMother {

    private RestauranteRequestMother (){}

    public static RestauranteRequest RestauranteRequestMotherMock(){
        return RestauranteRequest.builder()
                .nome("Pizzaria dos testes")
                .tipo(Tipo.PIZZARIA)
                .capacidade(10)
                .horarioAbertura("08:00")
                .horarioEncerramento("23:00")
                .localizacao("São Paulo")
                .build();

    }


}
