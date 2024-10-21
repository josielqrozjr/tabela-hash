package controllers;

import hash.TabelaHash;
import java.util.Scanner;

public class Controller {

    // Testar a estrutura de Tabela Hash
    public void testarTabelaHash(Scanner scanner) {

        boolean voltar = false;

        System.out.println("\n--- CONSTRUINDO A TABELA ----");
        System.out.print("Digite o tamanho da tabela: ");
        int tam = scanner.nextInt();
        TabelaHash tabela = new TabelaHash(tam);

        while (!voltar) {
            System.out.println("\nOperações na Tabela Hash:");
            System.out.println("1 - Buscar chave");
            System.out.println("2 - Imprimir tabela");
            System.out.println("3 - Número de colisões");
            System.out.println("0 - Voltar");

            System.out.print("\nDigite o número da opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    while (true) {
                        System.out.print("\nDigite uma chave para buscar (ou -1 para sair): ");
                        int chave = scanner.nextInt();
                        if (chave == -1) break;

                        if (tabela.busca(chave)) {
                            System.out.println("Chave " + chave + " encontrada.");
                        } else {
                            System.out.println("Chave " + chave + " não encontrada.");
                        }
                    }
                case 2:
                    tabela.mostrarTabela();
                    break;
                case 3:
                    System.out.println("Número de colisões: " + tabela.getColisoes());
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
