package com.example.techchallengetres.service;

import com.example.techchallengetres.controller.resources.RestauranteRequest;
import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.repository.RestauranteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static com.example.techchallengetres.mother.RestauranteEntityMother.criaListaDeRestaurantes;
import static com.example.techchallengetres.mother.RestauranteRequestMother.RestauranteRequestMotherMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class RestauranteServiceTests {

    @InjectMocks
    RestauranteService restauranteService;
    @Mock
    RestauranteRepository restauranteRepository;
    RestauranteRequest restauranteRequest;

    Restaurante restaurante;
    @Test
    @DisplayName("Teste Restaurante getRestaurantes")
    void getRestaurantesTest(){
        when(restauranteRepository.findAll()).thenReturn(Collections.singletonList(restaurante));
        List<Restaurante> restaurantes = restauranteService.getRestaurantes();
        assertEquals(Collections.singletonList(restaurante), restaurantes);
        verifyNoMoreInteractions(restauranteRepository);
    }

    @Test
    @DisplayName("Teste de recupera restaurante por id")
    void getRestaurantePorId(){

        List<Restaurante> restaurantesMock = criaListaDeRestaurantes();
        restauranteRepository.saveAll(restaurantesMock);


    }
    @Test
    @DisplayName("Teste de cadastro de restaurante")
    void cadastroRestaurante(){
        restauranteRequest = RestauranteRequestMotherMock();
        restauranteService.cadastraRestaurante(restauranteRequest);


    }




}
