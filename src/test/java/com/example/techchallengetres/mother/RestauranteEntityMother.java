package com.example.techchallengetres.mother;


import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.entity.enums.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestauranteEntityMother {


    private RestauranteEntityMother() {
    }

    public static List<Restaurante> criaListaDeRestaurantes() {
        List<Restaurante> restauranteEntities = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {

            restauranteEntities.add(Restaurante.builder()
                    .id(UUID.randomUUID())
                    .nome("")
                    .localizacao("")
                    .tipo(Tipo.PIZZARIA)
                    .horarioAbertura("")
                    .horarioEncerramento("")
                    .capacidade(10)
                    .mesas(new ArrayList<>())
                    .avaliacoes(new ArrayList<>())
                    .build());
        }

        return restauranteEntities;
    }

    public static Restaurante criaRestaurante() {
        return Restaurante.builder()
                .id(UUID.randomUUID())
                .nome("")
                .localizacao("")
                .tipo(Tipo.PIZZARIA)
                .horarioAbertura("")
                .horarioEncerramento("")
                .capacidade(10)
                .mesas(new ArrayList<>())
                .avaliacoes(new ArrayList<>())
                .build();

    }

}
