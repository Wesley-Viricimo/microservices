package com.wesley.proposta_app.service;

import com.wesley.proposta_app.dto.PropostaRequestDTO;
import com.wesley.proposta_app.dto.PropostaResponseDTO;
import com.wesley.proposta_app.entity.Proposta;
import com.wesley.proposta_app.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        propostaRepository.save(new Proposta());
        return null;
    }
}
