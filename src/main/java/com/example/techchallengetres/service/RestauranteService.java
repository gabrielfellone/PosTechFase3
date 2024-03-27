package com.example.techchallengetres.service;

import com.example.techchallengetres.controller.resources.AvaliacaoRequest;
import com.example.techchallengetres.controller.resources.MesaRequest;
import com.example.techchallengetres.controller.resources.RestauranteRequest;
import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.exception.RestauranteException;
import com.example.techchallengetres.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestauranteService {


    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private AvaliacaoService avaliacaoService;


    public List<Restaurante> getRestaurantes() {
        log.info("Buscando todos os restaurantes cadastrados");
        try {
            return restauranteRepository.findAll();
        } catch (RestauranteException e) {
            throw new RestauranteException("Erro ao buscar no banco de dados os restaurantes!");
        }
    }

    public void cadastraRestaurante(RestauranteRequest request) {
        log.info("Cadastrando o restaurante {}", request);
        Restaurante restaurante = new Restaurante(request);
        validaRequest(request);
        try {
            restauranteRepository.save(restaurante);
        } catch (RestauranteException e) {
            throw new RestauranteException("Erro ao cadastrar restaurante na base de dados!");
        }

    }

    public void incluiMesaRestaurante (MesaRequest request) {
        log.info("Cadastrando a Mesa {}", request);
        try {
            Optional<Restaurante> restaurante = getRestauranteById(request.getIdRestaurante());
            if (restaurante.isPresent()) {
                restaurante.get().getMesas().add(mesaService.criaMesaRestaurante(request));
                atualizaRestaurante(new Restaurante(restaurante));
            }
        } catch (RestauranteException e) {
            throw new RestauranteException("Erro ao cadastrar mesa na base de dados!");
        }

    }

    public Optional<Restaurante> getRestauranteById(UUID id) {
        log.info("Buscando Restaurante por ID: {}", id);
        try {
            return restauranteRepository.findById(id);
        } catch (RestauranteException e) {
            throw new RestauranteException("Erro ao buscar no banco de dados o restaurante!", e);
        }
    }

    public void atualizaRestaurante(Restaurante restaurante) {
        log.info("Atualizando o restaurante {}", restaurante);
        try {
            restauranteRepository.save(restaurante);
        } catch (RestauranteException e) {
            throw new RestauranteException("Erro ao atualizar restaurante na base de dados!");
        }

    }

    public void validaRequest(RestauranteRequest request) {
        if (request.getLocalizacao().chars().count() > 50) {
            throw new RestauranteException("Campo de localizacao maior que o permitido, por favor, validar!");
        }
        if (request.getCapacidade() > 200) {
            throw new RestauranteException("Campo de capacidade maior que o permitido, por favor, validar");
        }
    }

    public void realizaAvaliacao(AvaliacaoRequest request, UUID idRestaurante){
        Optional<Restaurante> restaurante = getRestauranteById(idRestaurante);
        if (restaurante.isPresent()) {
            if (restaurante.get().getAvaliacoes() == null){
                restaurante.get().setAvaliacoes(new ArrayList<>());
            }
            restaurante.get().getAvaliacoes().add(avaliacaoService.criaAvaliacao(request));
            atualizaRestaurante(new Restaurante(restaurante));
        } else throw new RestauranteException("Erro ao buscar restaurante");
    }


}
