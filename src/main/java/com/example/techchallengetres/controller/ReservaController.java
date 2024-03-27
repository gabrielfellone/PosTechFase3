package com.example.techchallengetres.controller;

import com.example.techchallengetres.controller.resources.ReservaRequest;
import com.example.techchallengetres.entity.Mesa;
import com.example.techchallengetres.service.ReservaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;
    @PostMapping("realizarReservaMesa")
    public ResponseEntity<String> realizaReserva(@RequestBody ReservaRequest request) {
        log.info("Reservar Mesa {}", request);
        reservaService.realizarReserva(request);
        return ResponseEntity.status(CREATED).body("Reserva realizada com sucesso!");
    }

    @GetMapping("listaReservasPorRestaurante")
    public ResponseEntity<List<Mesa>> getReservasPorRestaurante(@RequestParam(value = "id", required = true) UUID id) {
        log.info("Listar Reservas Por Restaurante {}", id);
        return ResponseEntity.ok(reservaService.verificaTodasReservasByRestaurante(id));
    }


}
