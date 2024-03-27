package com.example.techchallengetres.service;

import com.example.techchallengetres.controller.resources.MesaRequest;
import com.example.techchallengetres.controller.resources.ReservaRequest;
import com.example.techchallengetres.entity.Mesa;
import com.example.techchallengetres.entity.Restaurante;
import com.example.techchallengetres.entity.enums.Status;
import com.example.techchallengetres.exception.MesaException;
import com.example.techchallengetres.repository.MesaRepository;
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
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public void checaMesaDisponivel(Restaurante restaurante, ReservaRequest reserva) {
        log.info("Buscando Mesas do Restaurante {} por Status DISPONIVEL", restaurante);

        List<Mesa> mesas = mesaRepository.findAll().stream().filter(mesa ->
                Status.DISPONIVEL.equals(mesa.getStatus()) &&
                        mesa.getIdRestaurante().equals(restaurante.getId())).toList();

        if (!mesas.isEmpty()) {
            atualizaMesaRestaurante(reserva, mesas.get(0));
        } else throw new MesaException("Nao foi possivel encontrar mesa disponivel");

    }

    public void atualizaMesaRestaurante(ReservaRequest reserva, Mesa mesa) {
        log.info("Atualizando Mesa {} com Reserva {} ", mesa, reserva);

        mesa.setStatus(Status.RESERVADO);
        mesa.setDiaReserva(reserva.getDiaReserva());
        mesa.setHoraReserva(reserva.getHoraReserva());
        mesaRepository.save(mesa);

    }

    public List<Mesa> recuperaTodasAsReservasRestaurante(UUID idRestaurante) {
        log.info("Recuperando todas as mesas do restaurante {} ", idRestaurante);
        List<Mesa> mesas = mesaRepository.findAll().stream().filter(mesa ->
                mesa.getIdRestaurante().equals(idRestaurante)
                        && Status.RESERVADO.equals(mesa.getStatus())).toList();

        if (mesas.isEmpty()) {
            return new ArrayList<>();
        }
        return mesas;

    }

    public void atualizaStatusMesa(Integer numMesa, Status status) {
        Optional<Mesa> mesa = mesaRepository.findById(numMesa);
        if (mesa.isPresent()) {
            Mesa mesaUpdate = new Mesa(mesa);
            log.info("Atualizando Status da Mesa {} com Status {}", mesa, status);
            mesaUpdate.setStatus(status);
            mesaRepository.save(mesaUpdate);
        } else throw new MesaException("Mesa não encontrada!");

    }

    public int criaMesaRestaurante(MesaRequest mesaRequest){
        return mesaRepository.save(new Mesa(mesaRequest)).getNumeroMesa();
    }

}
