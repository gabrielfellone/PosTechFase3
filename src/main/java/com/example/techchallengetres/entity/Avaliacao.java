package com.example.techchallengetres.entity;

import com.example.techchallengetres.controller.resources.AvaliacaoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("avaliacao")
public class Avaliacao {

    @Column
    @PrimaryKey
    private UUID id;
    private String comentario;
    private int idUsuario;
    private int nota;

    public Avaliacao(AvaliacaoRequest request){
        this.id = UUID.randomUUID();
        this.comentario = request.getComentario();
        this.idUsuario = request.getIdUsuario();
        this.nota =  request.getNota();
    }
}
