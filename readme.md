# Aplicação de Criação de Pedido

## Descrição
- Esta aplicação tem como objetivo criar pedidos, persistir esses pedidos no banco de dados e enviar notificações ao usuário com a mensagem "Seu pedido foi criado, Pedido n°: {numeroPedido}".
## Estrutura do Projeto
O projeto está organizado da seguinte maneira:
- **src/main/java**: Contém a implementação das classes e serviços da aplicação.
- **src/test/java**: Contém os testes unitários e de integração.

## Classes Principais

### PedidoService
A classe `PedidoService` é responsável pela lógica de criação de pedidos. Ela utiliza o `PedidoRepository` para persistir os pedidos no banco de dados e o `NotificacaoService` para enviar notificações aos usuários.
