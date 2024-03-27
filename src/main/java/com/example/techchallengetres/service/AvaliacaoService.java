package com.example.techchallengetres.service;

import com.example.techchallengetres.controller.resources.AvaliacaoRequest;
import com.example.techchallengetres.entity.Avaliacao;
import com.example.techchallengetres.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public UUID criaAvaliacao(AvaliacaoRequest avaliacaoRequest){
       return avaliacaoRepository.save(new Avaliacao(avaliacaoRequest)).getId();
    }
}
