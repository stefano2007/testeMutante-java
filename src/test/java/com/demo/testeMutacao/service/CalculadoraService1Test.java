package com.demo.testeMutacao.service;

import com.demo.testeMutacao.model.CalcularMediaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraService1Test {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testCalcularMediaAprovado() {
        CalcularMediaDTO request = new CalcularMediaDTO(8, 7);
        String resultado = calculadoraService.calcularMedia(request);
        Assertions.assertEquals(CalculadoraService.APROVADO, resultado);
    }

    @Test
    public void testCalcularMediaRecuperacao() {
        CalcularMediaDTO request = new CalcularMediaDTO(6, 5);
        String resultado = calculadoraService.calcularMedia(request);
        Assertions.assertEquals(CalculadoraService.RECUPERACAO, resultado);
    }

    @Test
    public void testCalcularMediaReprovado() {
        CalcularMediaDTO request = new CalcularMediaDTO(3, 4);
        String resultado = calculadoraService.calcularMedia(request);
        Assertions.assertEquals(CalculadoraService.REPROVADO, resultado);
    }
}
