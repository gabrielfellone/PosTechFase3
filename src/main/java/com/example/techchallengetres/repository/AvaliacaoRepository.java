package com.example.techchallengetres.repository;

import com.example.techchallengetres.entity.Avaliacao;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AvaliacaoRepository extends CassandraRepository<Avaliacao, Integer> {


}
