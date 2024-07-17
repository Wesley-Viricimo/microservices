package org.wesley.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.wesley.dto.PropostaRequestDTO;
import org.wesley.dto.PropostaResponseDTO;
import org.wesley.service.PropostaService;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO requestDTO) {
        PropostaResponseDTO response = propostaService.criar(requestDTO);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(response.getId())
                        .toUri())               //Implementação que retornará no location do header da resposta da requisição uma url para acessar a proposta que foi criada
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> obterPropostas() {
        return ResponseEntity.ok().body(propostaService.obterPropostas());
    }
}
