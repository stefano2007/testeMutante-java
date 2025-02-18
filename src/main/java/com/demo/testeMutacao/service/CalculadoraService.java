package com.demo.testeMutacao.service;

import com.demo.testeMutacao.exceptions.NotaInvalidaException;
import com.demo.testeMutacao.model.CalcularMediaDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO = "REPROVADO";
    public static final String RECUPERACAO = "RECUPERACAO";

    public String calcularMedia(CalcularMediaDTO notas) throws NotaInvalidaException {
        validaNotas(notas);

        var media = (notas.nota1() + notas.nota2()) / 2;
        if (media >= 7) {
            return APROVADO;
        }

        if (media >= 5) {
            return RECUPERACAO;
        }

        return REPROVADO;
    }

    public void validaNotas(CalcularMediaDTO notas) throws NotaInvalidaException {
        validaNota(notas.nota1());
        validaNota(notas.nota2());
    }

    private void validaNota(double nota) throws NotaInvalidaException {
        if (nota < 0.0 || nota > 10.0){
            throw new NotaInvalidaException("Nota invalida, deve ser entre 0 e 10");
        }
    }
}




/*
@Service
public class CalculadoraService {

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO = "REPROVADO";
    public static final String RECUPERACAO = "RECUPERACAO";

    public String calcularMedia(CalcularMediaDTO notas) throws NotaInvalidaException {
        validaNotas(notas);

        var media = calcularMedia(notas.nota1(), notas.nota2());

        return media >= 7 ? APROVADO :
                media >= 5 ? RECUPERACAO : REPROVADO;
    }

    public void validaNotas(CalcularMediaDTO notas) throws NotaInvalidaException {
        validaNota(notas.nota1());
        validaNota(notas.nota2());
    }

    private void validaNota(double nota) throws NotaInvalidaException {
        if (nota < 0.0 || nota > 10.0){
            throw new NotaInvalidaException("Nota invalida, deve ser entre 0 e 10");
        }
    }

    private double calcularMedia(Double nota1, Double nota2) {
        return (nota1 + nota2) / 2;
    }
}
*/
