package com.example.techchallengetres.service;

import com.example.techchallengetres.controller.resources.ReservaRequest;
import com.example.techchallengetres.entity.Mesa;
import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.entity.enums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservaService {

    @Autowired
    private RestauranteService restauranteService;
    @Autowired
    private MesaService mesaService;

    public void realizarReserva(ReservaRequest request) {

        log.info("Verificando reserva da mesa  {}", request);

        Restaurante restaurante =
                new Restaurante(restauranteService.getRestauranteById(request.getIdRestaurante()));

        validaHorarioRestaurante(restaurante, request);
        validaMesaDisponivel(restaurante, request);

    }
    public void validaHorarioRestaurante(Restaurante restaurante,
                              ReservaRequest reserva) {

        log.info("Validando horario da reserva");

        //ToDo Logica para verificar hora e dia disponivel

        String horaAbertura = restaurante.getHorarioAbertura();
        String horaEncerramento = restaurante.getHorarioEncerramento();

        String horaReserva = reserva.getHoraReserva();
        String diaReserva = reserva.getDiaReserva();

    }
    public void validaMesaDisponivel(Restaurante restaurante, ReservaRequest reserva) {
        log.info("Validando mesa disponivel para o restaurante {}", restaurante);
        mesaService.checaMesaDisponivel(restaurante, reserva);
    }

    public List<Mesa> verificaTodasReservasByRestaurante(UUID idRestaurante){
        log.info("Verificando Lista de Reservas");
        return mesaService.recuperaTodasAsReservasRestaurante(idRestaurante);
    }

    public void atualizaStatusMesa(Integer mesa, Status status){
        log.info("Atualizando Status da Mesa {}", mesa);
        mesaService.atualizaStatusMesa(mesa, status);

    }

}
