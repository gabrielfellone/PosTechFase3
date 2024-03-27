package com.example.techchallengetres.repository;

import com.example.techchallengetres.entity.Restaurante;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface RestauranteRepository extends CassandraRepository<Restaurante, UUID> {


}
