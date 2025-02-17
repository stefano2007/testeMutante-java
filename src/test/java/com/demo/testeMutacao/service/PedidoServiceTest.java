package com.demo.testeMutacao.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.text.MessageFormat;

import com.demo.testeMutacao.model.Pedido;
import com.demo.testeMutacao.model.dto.CriarPedidoDTO;
import com.demo.testeMutacao.model.dto.PedidoDTO;
import com.demo.testeMutacao.model.enums.StatusPedido;
import com.demo.testeMutacao.repositories.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

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






/*
   //BUG: var novoValor = pedido.getValor().multiply(BigDecimal.valueOf(1.1));
   //     pedido.setValor(novoValor);

    @Test
    public void testCriarPedidoCompleto() {
        //Arrange
        Long idPedido = 123l;
        Integer usuarioId = 125;
        CriarPedidoDTO criarPedidoDTO = new CriarPedidoDTO("Caneta", 1,
                BigDecimal.valueOf(2.00), usuarioId);

        doAnswer(invocation -> {
            Pedido p = invocation.getArgument(0);
            p.setId(idPedido);
            return null;
        }).when(pedidoRepository).save(any(Pedido.class));

        //Act
        var resultado = pedidoService.criarPedido(criarPedidoDTO);

        //Assert
        verify(pedidoRepository).save(any(Pedido.class));
        verify(notificacaoService).enviarNotificacao(eq(usuarioId),
                eq(MessageFormat.format("Seu pedido foi criado, Pedido n°: {0}",
                        idPedido)));

        assertEquals(StatusPedido.CRIADO, resultado.statusPedido());

        assertEquals(idPedido, resultado.id());
        assertEquals(criarPedidoDTO.produto(), resultado.produto());
        assertEquals(criarPedidoDTO.quantidade(), resultado.quantidade());
        assertEquals(criarPedidoDTO.valor(), resultado.valor());
    }
    */

}