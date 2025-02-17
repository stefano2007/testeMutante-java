package com.demo.testeMutacao.model.dto;

import com.demo.testeMutacao.model.Pedido;
import com.demo.testeMutacao.model.enums.StatusPedido;

import java.math.BigDecimal;

public record PedidoDTO(Long id, String produto, Integer quantidade,
                        BigDecimal valor, Integer usuarioId, StatusPedido statusPedido) {

    public static PedidoDTO PedidoParaDTO(Pedido pedido){
        return new PedidoDTO(pedido.getId(), pedido.getProduto(),
                pedido.getQuantidade(),pedido.getValor(),
                pedido.getUsuarioId(), pedido.getStatusPedido());
    }
}
