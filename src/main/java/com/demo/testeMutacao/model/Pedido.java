package com.demo.testeMutacao.model;

import com.demo.testeMutacao.model.enums.StatusPedido;

import java.math.BigDecimal;

public class Pedido {

    private Long id;

    private String produto;

    private Integer quantidade;

    private BigDecimal valor;

    private Integer usuarioId;

    private StatusPedido statusPedido;

    public Pedido(){}

    public Pedido(Long id, String produto, Integer quantidade,
                  BigDecimal valor, Integer usuarioId,
                  StatusPedido statusPedido) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.statusPedido = statusPedido;
        this.usuarioId = usuarioId;
    }

    private Pedido(String produto, Integer quantidade, BigDecimal valor,
                   Integer usuarioId, StatusPedido statusPedido) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.usuarioId = usuarioId;
        this.statusPedido = statusPedido;
    }

    public static Pedido criarPedido(String produto, Integer quantidade,
                                     BigDecimal valor, Integer usuarioId) {
        return new Pedido(produto, quantidade, valor, usuarioId, StatusPedido.CRIADO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
