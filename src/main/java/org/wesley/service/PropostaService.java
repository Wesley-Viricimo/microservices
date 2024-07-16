package org.wesley.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesley.dto.PropostaRequestDTO;
import org.wesley.dto.PropostaResponseDTO;
import org.wesley.entity.Proposta;
import org.wesley.repository.PropostaRepository;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        propostaRepository.save(new Proposta());
        return null;
    }
}
