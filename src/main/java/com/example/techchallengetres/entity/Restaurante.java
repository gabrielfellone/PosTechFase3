package com.example.techchallengetres.entity;


import com.example.techchallengetres.controller.resources.RestauranteRequest;
import com.example.techchallengetres.entity.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("restaurante")
public class Restaurante {

    @Column
    @PrimaryKey
    private UUID id;
    private String nome;
    private String localizacao;
    private Tipo tipo;
    private String horarioAbertura;
    private String horarioEncerramento;
    private int capacidade;
    private List<Integer> mesas;
    private List<UUID> avaliacoes;


    public Restaurante(RestauranteRequest request){
        this.id = UUID.randomUUID();
        this.nome = request.getNome();
        this.localizacao = request.getLocalizacao();
        this.tipo = request.getTipo();
        this.horarioAbertura = request.getHorarioAbertura();
        this.horarioEncerramento = request.getHorarioEncerramento();
        this.capacidade = request.getCapacidade();
        this.mesas = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();

    }

    public Restaurante(Optional<Restaurante> restaurante){
        if(restaurante.isPresent()){
            this.id = UUID.randomUUID();
            this.nome = restaurante.get().getNome();
            this.localizacao = restaurante.get().getLocalizacao();
            this.tipo = restaurante.get().getTipo();
            this.horarioAbertura = restaurante.get().getHorarioAbertura();
            this.horarioEncerramento = restaurante.get().getHorarioEncerramento();
            this.capacidade = restaurante.get().getCapacidade();
            this.mesas = restaurante.get().getMesas();
            this.avaliacoes = restaurante.get().getAvaliacoes();
        }
    }

}
