# Aplicação de Criação de Pedido

## Descrição
Esta aplicação tem como objetivo criar pedidos, persistir esses pedidos no banco de dados e enviar notificações ao usuário. A aplicação é implementada em Java utilizando o framework Spring.

## Estrutura do Projeto
O projeto está organizado da seguinte maneira:
- **src/main/java**: Contém a implementação das classes e serviços da aplicação.
- **src/test/java**: Contém os testes unitários e de integração.

## Classes Principais

### PedidoService
A classe `PedidoService` é responsável pela lógica de criação de pedidos. Ela utiliza o `PedidoRepository` para persistir os pedidos no banco de dados e o `NotificacaoService` para enviar notificações aos usuários.

```java
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
