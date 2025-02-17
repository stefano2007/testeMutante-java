package com.demo.testeMutacao.repositories.impl;

import com.demo.testeMutacao.model.Pedido;
import com.demo.testeMutacao.repositories.PedidoRepository;
import org.springframework.stereotype.Component;

@Component
public class PedidoRepositoryImpl implements PedidoRepository {
    @Override
    public void save(Pedido pedido) {
        pedido.setId(1L);
    }
}
