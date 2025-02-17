# Projeto Calculadora de Média

## Descrição
Este projeto tem como objetivo calcular a média de duas notas fornecidas pelo usuário e classificar o resultado de acordo com as seguintes regras:
- Aprovado: Média maior ou igual a 7
- Recuperação: Média maior ou igual a 5 e menor que 7
- Reprovado: Média menor que 5

O projeto utiliza Java Spring para a implementação do serviço de cálculo de média e PITest para testes de mutação.

## Estrutura do Projeto
O projeto está organizado da seguinte maneira:
- **src/main/java**: Contém a implementação do serviço de cálculo de média.
- **src/test/java**: Contém os testes unitários e de mutação.

## Implementação
A classe `CalculadoraService` é responsável pelo cálculo da média e pela classificação do resultado. A seguir, o código da implementação:

```java
@Service
public class CalculadoraService {
    public static final String APROVADO = "APROVADO";
    public static final String REPROVADO = "REPROVADO";
    public static final String RECUPERACAO = "RECUPERACAO";

    public String calcularMedia(CalcularMediaDTO notas) {
        var media = (notas.nota1() + notas.nota2()) / 2;
        if (media >= 7) {
            return APROVADO;
        }
        if (media >= 5) {
            return RECUPERACAO;
        }
        return REPROVADO;
    }
}
