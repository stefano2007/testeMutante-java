package com.demo.testeMutacao.controller;

import com.demo.testeMutacao.exceptions.NotaInvalidaException;
import com.demo.testeMutacao.model.CalcularMediaDTO;
import com.demo.testeMutacao.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("calcular-media")
    public ResponseEntity<String> calcularMedia(@RequestBody CalcularMediaDTO request) {
        try {
            return ResponseEntity.ok(calculadoraService.calcularMedia(request));
        } catch (NotaInvalidaException e){
            return ResponseEntity.badRequest().body(e.getMensagemError());
        }
    }
}
