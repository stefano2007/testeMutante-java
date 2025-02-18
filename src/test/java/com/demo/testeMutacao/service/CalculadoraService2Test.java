package com.demo.testeMutacao.service;

import com.demo.testeMutacao.exceptions.NotaInvalidaException;
import com.demo.testeMutacao.model.CalcularMediaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraService2Test {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    final String mensagemErroEsperada = "Nota invalida, deve ser entre 0 e 10";

    @Test
    public void testCalcularMediaNotaInvalidaMenorNota1() {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(-0.1, 7.0);

        //Act
        var exception = Assertions.assertThrows(NotaInvalidaException.class,
                () -> calculadoraService.calcularMedia(request)
        );

        //Assert
        Assertions.assertEquals(mensagemErroEsperada, exception.getMessage());
    }

    @Test
    public void testCalcularMediaNotaInvalidaMaiorNota1() {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(10.1, 7.0);

        //Act
        var exception = Assertions.assertThrows(NotaInvalidaException.class,
                () -> calculadoraService.calcularMedia(request)
        );

        //Assert
        Assertions.assertEquals(mensagemErroEsperada, exception.getMessage());
    }

    @Test
    public void testCalcularMediaNotaInvalidaMenorNota2() {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(7.0, -0.1);

        //Act
        var exception = Assertions.assertThrows(NotaInvalidaException.class,
                () -> calculadoraService.calcularMedia(request)
        );

        //Assert
        Assertions.assertEquals(mensagemErroEsperada, exception.getMessage());
    }

    @Test
    public void testCalcularMediaNotaInvalidaMaiorNota2() {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(7.0, 10.1);

        //Act
        var exception = Assertions.assertThrows(NotaInvalidaException.class,
                () -> calculadoraService.calcularMedia(request)
        );

        //Assert
        Assertions.assertEquals(mensagemErroEsperada, exception.getMessage());
    }

    @Test
    public void testCalcularMediaReprovadoMenorNota()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(0.0, 0.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.REPROVADO, resultado);
    }

    @Test
    public void testCalcularMediaReprovadoMaiorNota()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(4.9, 4.9);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.REPROVADO, resultado);
    }

    @Test
    public void testCalcularMediaRecuperacaoMenor()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(5.0, 5.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.RECUPERACAO, resultado);
    }

    @Test
    public void testCalcularMediaRecuperacaoMaior()  throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(6.99, 6.99);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.RECUPERACAO, resultado);
    }

    @Test
    public void testCalcularMediaAprovadoMenorNota() throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(7.0, 7.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.APROVADO, resultado);
    }

    @Test
    public void testCalcularMediaAprovadoMaiorNota() throws NotaInvalidaException {
        //Arrange
        CalcularMediaDTO request = new CalcularMediaDTO(10.0, 10.0);

        //Act
        String resultado = calculadoraService.calcularMedia(request);

        //Assert
        Assertions.assertEquals(CalculadoraService.APROVADO, resultado);
    }
}
