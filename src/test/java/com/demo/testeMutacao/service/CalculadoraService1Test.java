package com.demo.testeMutacao.service;

import com.demo.testeMutacao.exceptions.NotaInvalidaException;
import com.demo.testeMutacao.model.CalcularMediaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraService1Test {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testCalcularMediaNotaInvalida() {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(18.0, 7.0);

        //Act
        var exception = Assertions.assertThrows(NotaInvalidaException.class,
                () -> calculadoraService.calcularMedia(request)
        );

        //Assert
        Assertions.assertEquals("Nota invalida, deve ser entre 0 e 10", exception.getMessage());
    }

    @Test
    public void testCalcularMediaReprovado()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(3.0, 4.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.REPROVADO, resultado);
    }

    @Test
    public void testCalcularMediaRecuperacao()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(6.0, 5.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.RECUPERACAO, resultado);
    }

    @Test
    public void testCalcularMediaAprovado() throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(8.0, 7.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.APROVADO, resultado);
    }
}
