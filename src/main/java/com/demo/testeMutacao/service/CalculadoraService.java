package com.demo.testeMutacao.service;

import com.demo.testeMutacao.model.CalcularMediaDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO = "REPROVADO";
    public static final String RECUPERACAO = "RECUPERACAO";

    public String calcularMedia(CalcularMediaDTO notas) {
        var media = (notas.nota1() + notas.nota2()) / 2;

        if (media >= 7) {
            return APROVADO;
        }

        if (media >= 5) {
            return RECUPERACAO;
        }

        return REPROVADO;
    }
}


/*
public class CalculadoraService {

    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO = "REPROVADO";
    public static final String RECUPERACAO = "RECUPERACAO";

    public String calcularMedia(CalcularMediaDTO notas) {
        var media = calcularMedia(notas.nota1(), notas.nota2());

        return media >= 7 ? APROVADO :
               media >= 5 ? RECUPERACAO : REPROVADO;
    }

    private double calcularMedia(Double nota1, Double nota2) {
        return (nota1 + nota2) / 2;
    }
}
*/
