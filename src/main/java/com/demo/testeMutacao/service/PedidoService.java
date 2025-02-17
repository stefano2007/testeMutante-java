package com.demo.testeMutacao.service;

import com.demo.testeMutacao.model.Pedido;
import com.demo.testeMutacao.model.dto.CriarPedidoDTO;
import com.demo.testeMutacao.model.dto.PedidoDTO;
import com.demo.testeMutacao.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private NotificacaoService notificacaoService;

    public PedidoDTO criarPedido(CriarPedidoDTO criarPedidoDTO) {
        Pedido pedido = criarPedidoDTO.converteParaPedido();
        pedidoRepository.save(pedido);

        notificacaoService.enviarNotificacao(pedido.getUsuarioId(),
                 MessageFormat.format("Seu pedido foi criado, Pedido n°: {0}",
                 pedido.getId())
        );

        return PedidoDTO.PedidoParaDTO(pedido);
    }
}