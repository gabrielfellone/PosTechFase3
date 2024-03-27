package com.example.techchallengetres.repository.integration;

import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.repository.RestauranteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.techchallengetres.mother.RestauranteEntityMother.criaListaDeRestaurantes;
import static com.example.techchallengetres.mother.RestauranteEntityMother.criaRestaurante;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class RestauranteRepositoryIntegrationTests {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    @DisplayName("Valida Integracao com Banco de Dados Restaurante")
    void deveValidarNumeroDeTabelas(){
        var totalTabelas = restauranteRepository.count();
        assertTrue(totalTabelas >= 0);

    }

    @Test
    @DisplayName("Salva Restaurante No Banco de Dados COM Integracao")
    void deveSalvarNoBancoDeDados(){
        Restaurante restaurante = criaRestaurante();
        var response = restauranteRepository.save(restaurante);

        assertAll(
                () -> assertNotNull(response)
        );

    }

    @Test
    @DisplayName("Recupera Restaurante No Banco de Dados COM Integracao")
    void deveRecuperaResturanteNoBancoPorId(){
        Restaurante restaurante = criaRestaurante();
        var response = restauranteRepository.save(restaurante);
        var responseGetById = restauranteRepository.findById(response.getId());

        assertAll(
                () -> assertNotNull(responseGetById),
                () -> assertNotNull(response),
                () -> assertEquals(response.getId(),responseGetById.get().getId())
        );

    }

    @Test
    @DisplayName("Atualiza Restaurante No Banco de Dados COM Integracao")
    void deveRealizarAtualizacaoRestauranteNoBanco(){

        Restaurante restaurante = criaRestaurante();
        var response = restauranteRepository.save(restaurante);

        response.setNome("Restaurante Batata");
        restauranteRepository.save(response);

        assertAll(
                () -> assertEquals(response.getNome(), "Restaurante Batata")
        );

    }

    @Test
    @DisplayName("Lista Restaurante No Banco de Dados COM Integracao")
    void deveListarTodosOsRestaurantes(){

        List<Restaurante> restaurantes = criaListaDeRestaurantes();
        restauranteRepository.saveAll(restaurantes);

        List<Restaurante> response = restauranteRepository.findAll();

        assertAll(
                () -> assertFalse(response.isEmpty())
        );

    }


}
