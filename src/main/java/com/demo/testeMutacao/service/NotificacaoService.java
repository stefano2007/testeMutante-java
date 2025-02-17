package com.demo.testeMutacao.service;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class NotificacaoService {
    public void enviarNotificacao(Integer usuarioId, String mensagem){
        var montaMensagemCompleta = MessageFormat.format("mensagem: {0} para o usuario: {1}",
                        mensagem, usuarioId);

        System.out.println(montaMensagemCompleta);
    }
}
