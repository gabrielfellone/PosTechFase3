
TechChallenge

Fase 3 - Pós 2ADJT

Aluno: Gabriel Fellone RM350771

Sobre a solução:

Foram criadas as entidades de Restaurante, Mesa e Avaliacao.
Onde o mesmo possui a seguinte estrtura:


controller – as classes de chamadas de api onde possui os endpoints e resources

entity – as classes de entidades, dominios do sistema

exceptions – exceções personalizadas

repository – possui as classes/interfaces/entidades para banco de dados

services – classes de serviços para manipular os domains, regras de negócio, etc

------------------


Roteiro de teste:

O codigo esta no github na MASTER

https://github.com/gabrielfellone/PosTechFase3


Comandos:

docker pull cassandra

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



Para testar o código é possível entrar no Swagger através da URL

http://localhost:8080/swagger-ui/index.html#/

