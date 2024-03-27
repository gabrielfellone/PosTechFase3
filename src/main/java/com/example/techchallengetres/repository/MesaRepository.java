package com.example.techchallengetres.repository;

import com.example.techchallengetres.entity.Mesa;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MesaRepository extends CassandraRepository<Mesa, Integer> {


}
