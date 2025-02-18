package com.demo.testeMutacao.controller;

import com.demo.testeMutacao.model.dto.CriarPedidoDTO;
import com.demo.testeMutacao.model.dto.PedidoDTO;
import com.demo.testeMutacao.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PedidoController {

    @Autowired
    private PedidoService perdidoService;

    @PostMapping("criar-pedido")
    public ResponseEntity<PedidoDTO> criaPedido(@RequestBody CriarPedidoDTO request) {
        return ResponseEntity.ok(perdidoService.criarPedido(request));
    }
}
