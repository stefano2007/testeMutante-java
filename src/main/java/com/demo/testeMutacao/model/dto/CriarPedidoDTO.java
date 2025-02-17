package com.demo.testeMutacao.model.dto;

import com.demo.testeMutacao.model.Pedido;

import java.math.BigDecimal;

public record CriarPedidoDTO(String produto, Integer quantidade,
                             BigDecimal valor, Integer usuarioId) {
    public Pedido converteParaPedido(){
        return Pedido.criarPedido(produto, quantidade, valor, usuarioId);
    }
}
