

docker run -d --name cassandra-docker -p 9042:9042 cassandra

docker exec -it cassandra-docker bash

cqlsh


create keyspace techchallengetres with replication={'class':'SimpleStrategy', 'replication_factor':1};



CREATE TABLE restaurante (
    id UUID,
    nome text,
    localizacao text,
    tipo text,
    horarioAbertura text,
    horarioEncerramento text,
    capacidade int,
    mesas list<int>,
    avaliacoes list<UUID>,
    PRIMARY KEY (id)
);


CREATE TABLE mesa (
    numeroMesa int,
    idRestaurante UUID,
    diaReserva text,
    horaReserva text,
    status text,
    PRIMARY KEY (numeroMesa)
);



CREATE TABLE avaliacao (
    id UUID PRIMARY KEY,
    comentario text,
    idUsuario int,
    nota int
);
