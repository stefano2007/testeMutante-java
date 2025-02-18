package com.demo.testeMutacao.service;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class NotificacaoService {
    public void enviarNotificacao(Integer usuarioId, String mensagem) {
        System.out.println(MessageFormat.format("mensagem: {0}", mensagem));
        System.out.println(MessageFormat.format("Para o usuario: {1}", usuarioId));
    }
}
