package com.example.techchallengetres.repository;

import com.example.techchallengetres.entity.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static com.example.techchallengetres.mother.RestauranteEntityMother.criaListaDeRestaurantes;
import static com.example.techchallengetres.mother.RestauranteEntityMother.criaRestaurante;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestauranteRepositoryTests {

    @Mock
    private RestauranteRepository restauranteRepository;
    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {

        openMocks.close();
    }

    @Test
    @DisplayName("Cria Restaurante No Banco de Dados Sem Integracao")
    void deveCriarResturanteNoBanco(){
        Restaurante restaurante = criaRestaurante();
        when(restauranteRepository.save(restaurante)).thenReturn(restaurante);
        var response = restauranteRepository.save(restaurante);
        assertAll(
                () -> assertEquals(response, restaurante)
        );
        verify(restauranteRepository, times(1)).save(restaurante);
        verifyNoMoreInteractions(restauranteRepository);
    }

    @Test
    @DisplayName("Recupera Restaurante No Banco de Dados Sem Integracao")
    void deveRecuperaResturanteNoBancoPorId(){
        Restaurante restaurante = criaRestaurante();
        when(restauranteRepository.findById(restaurante.getId())).thenReturn(Optional.of(restaurante));
        var response = restauranteRepository.findById(restaurante.getId());
        assertAll(
                () -> assertNotNull(response),
                () -> assertEquals(response.get().getId(), restaurante.getId())
        );

        verifyNoMoreInteractions(restauranteRepository);

    }

    @Test
    @DisplayName("Atualiza Restaurante No Banco de Dados Sem Integracao")
    void deveRealizarAtualizacaoRestauranteNoBanco(){

        Restaurante restaurante = criaRestaurante();
        when(restauranteRepository.save(restaurante)).thenReturn(restaurante);
        var response = restauranteRepository.save(restaurante);

        response.setNome("Restaurante Batata");
        restauranteRepository.save(response);

        assertAll(
                () -> assertEquals(response.getNome(), "Restaurante Batata")
        );

        verify(restauranteRepository, times(2)).save(restaurante);
        verifyNoMoreInteractions(restauranteRepository);
    }

    @Test
    @DisplayName("Lista Restaurante No Banco de Dados Sem Integracao")
    void deveListarTodosOsRestaurantes(){

        List<Restaurante> restaurantesMock = criaListaDeRestaurantes();
        when(restauranteRepository.findAll()).thenReturn(restaurantesMock);

        var response = restauranteRepository.findAll();

        assertAll(
                () -> assertEquals(response.size(), restaurantesMock.size())
        );
        verifyNoMoreInteractions(restauranteRepository);
        verify(restauranteRepository, times(1)).findAll();

    }


}
