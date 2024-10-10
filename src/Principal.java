import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha;
        String moeda1 = "";
        String moeda2 = "";
        double valor;

        while (true) {
            System.out.println("""
                    
                    
                    *******************************************************
                    Seja Bem-vindo/a ao Conversor de Moeda :)
                    
                    Escolha uma opção para Conversão de Valores:
                    
                    1. Dólar =>> Peso Argentino
                    2. Peso Argentino =>> Dólar
                    3. Dólar =>> Real
                    4. Real =>> Dólar
                    5. Dólar =>> Peso colombiano
                    6. Peso colombiano =>> Dólar 
                    7. Sair
                    
                    Escolha uma opção válida:
                    *******************************************************
                    """);
            try {
                escolha = scanner.nextInt(); // Lê a opção do usuário
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpa a entrada inválida
                continue;
            }


            if (escolha == 7) {
                System.out.println("Operação encerrada.");
                break;
            } else {

                switch (escolha) {
                    case 1:
                        moeda1 = "USD";
                        moeda2 = "ARS";
                        break;
                    case 2:
                        moeda1 = "ARS";
                        moeda2 = "USD";
                        break;
                    case 3:
                        moeda1 = "USD";
                        moeda2 = "BRL";
                        break;
                    case 4:
                        moeda1 = "BRL";
                        moeda2 = "USD";
                        break;
                    case 5:
                        moeda1 = "USD";
                        moeda2 = "COP";
                        break;
                    case 6:
                        moeda1 = "COP";
                        moeda2 = "USD";
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        scanner.next(); // Limpa a e5ntrada inválida
                        continue;
                }
                try {
                    System.out.println("Digite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    // Chamando o classe que envia a solicitação a API
                    SolitacaoCliente.EnviaSolicitacao(moeda1, moeda2, valor); // Realizando a conversão
                } catch (Exception e) {
                    System.out.println("Valor inválido. Por favor, insira um número válido.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }
        }
        scanner.close();
    }
}
