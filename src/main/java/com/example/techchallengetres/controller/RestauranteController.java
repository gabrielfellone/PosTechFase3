package com.example.techchallengetres.controller;

import com.example.techchallengetres.controller.resources.AvaliacaoRequest;
import com.example.techchallengetres.controller.resources.MesaRequest;
import com.example.techchallengetres.controller.resources.RestauranteRequest;
import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService restauranteService;

    @GetMapping("listaRestaurantes")
    public ResponseEntity<List<Restaurante>> getRestaurantes() {
        log.info("Listar todos os restaurantes");
        return ResponseEntity.ok(restauranteService.getRestaurantes());
    }

    @PostMapping("cadastrarRestaurante")
    public ResponseEntity<String> cadastraRestaurante(@RequestBody RestauranteRequest request) {
        log.info("Criar restaurante {}", request);
        restauranteService.cadastraRestaurante(request);
        return ResponseEntity.status(CREATED).body("Cadastro do restaurante efetuado com sucesso!");
    }

    @PostMapping("incluirMesas")
    public ResponseEntity<String> incluirMesas(@RequestBody MesaRequest request) {
        log.info("Incluindo Mesa {} no Restaurante {}", request, request.getIdRestaurante());
        restauranteService.incluiMesaRestaurante(request);
        return ResponseEntity.status(CREATED).body("Cadastro da mesa efetuado com sucesso!");
    }

    @PostMapping("realizaAvaliacao/{id}")
    public ResponseEntity<String> realizaAvaliacao(@RequestBody AvaliacaoRequest request,
                                                   @RequestParam(value = "id", required = true) UUID id) {
        log.info("Salvando Avaliacao no Restaurante {}", id);
        restauranteService.realizaAvaliacao(request, id);
        return ResponseEntity.status(CREATED).body("Avaliacao do restaurante efetuado com sucesso!");
    }


}
