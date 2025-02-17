package com.demo.testeMutacao.model.enums;

public enum StatusPedido {
    CRIADO("Pedido Criado"),
    PAGAMENTO_CONFIRMADO("Pagamento Confirmado"),
    DESPACHADO("Pedido Despachado"),
    ENTREGUE("Pedido Entregue"),
    CANCELADO("Pedido Cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

