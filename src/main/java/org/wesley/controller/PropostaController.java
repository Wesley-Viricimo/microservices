package org.wesley.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wesley.dto.PropostaRequestDTO;
import org.wesley.dto.PropostaResponseDTO;
import org.wesley.service.PropostaService;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO requestDTO) {
        PropostaResponseDTO response = propostaService.criar(requestDTO);
        return ResponseEntity.ok().body(response);
    }
}
