package com.demo.testeMutacao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.math.BigDecimal;

import com.demo.testeMutacao.model.dto.CriarPedidoDTO;
import com.demo.testeMutacao.model.enums.StatusPedido;
import com.demo.testeMutacao.repositories.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoService1Test {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private NotificacaoService notificacaoService;

    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    public void setup() {}

    @Test
    public void testCriarPedido() {
        //Arrange
        Integer usuarioId = 125;
        CriarPedidoDTO criarPedidoDTO = new CriarPedidoDTO("Caneta", 1,
                BigDecimal.valueOf(2.00), usuarioId);

        //Act
        var resultado = pedidoService.criarPedido(criarPedidoDTO);

        //Assert
        assertNotNull(resultado);
        assertEquals(StatusPedido.CRIADO, resultado.statusPedido());
    }





   //BUG: var novoValor = pedido.getValor().multiply(BigDecimal.valueOf(1.1));
   //     pedido.setValor(novoValor);

}