package org.wesley.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesley.dto.PropostaRequestDTO;
import org.wesley.dto.PropostaResponseDTO;
import org.wesley.entity.Proposta;
import org.wesley.mapper.PropostaMapper;
import org.wesley.repository.PropostaRepository;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificacaoService notificacaoService;

    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {

       Proposta proposta = PropostaMapper.INSTANCE.converteDtoToProposta(requestDTO);
       propostaRepository.save(proposta);

       PropostaResponseDTO response = PropostaMapper.INSTANCE.converteEntityToDto(proposta);
       notificacaoService.notificar(response, "proposta-pendente.ex");

       return response;
    }

    public List<PropostaResponseDTO> obterPropostas() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
