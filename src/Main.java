import controllers.Controller;
import java.util.Scanner;

// Menu para interagir com as classes de cada estrutura
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        boolean sair = false;


        while (!sair) {
            System.out.println("\nEscolha a estrutura para testar:");
            System.out.println("1 - Tabela Hash");
            System.out.println("0 - Encerrar");

            System.out.print("\nDigite o número da opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controller.testarTabelaHash(scanner);
                    break;
                case 0:
                    sair = true;
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
