package controllers;

import lista.ListaEncadeada;
import lista.Celula;
import java.util.Scanner;

public class Controller {

    // Testar a estrutura de Lista Encadeada
    public void testarListaEncadeada(Scanner scanner) {
        ListaEncadeada lista = new ListaEncadeada();
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\nOperações na Lista Encadeada:");
            System.out.println("1 - Inserir no início");
            System.out.println("2 - Inserir no final");
            System.out.println("3 - Inserir ordenadamente");
            System.out.println("4 - Remover primeiro");
            System.out.println("5 - Remover último");
            System.out.println("6 - Remover elemento específico");
            System.out.println("7 - Mostrar lista");
            System.out.println("0 - Voltar");

            System.out.print("\nDigite o número da opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o valor para inserir no início: ");
                    int valorInicio = scanner.nextInt();
                    lista.inserePrimeiro(valorInicio);
                    break;
                case 2:
                    System.out.print("\nDigite o valor para inserir no final: ");
                    int valorFinal = scanner.nextInt();
                    lista.insereUltimo(valorFinal);
                    break;
                case 3:
                    System.out.print("\nDigite o valor para inserir ordenadamente: ");
                    int valorOrdenado = scanner.nextInt();
                    lista.insereOrdenado(valorOrdenado);
                    break;
                case 4:
                    lista.removePrimeiro();
                    System.out.println("Primeiro elemento removido.");
                    break;
                case 5:
                    lista.removeUltimo();
                    System.out.println("Último elemento removido.");
                    break;
                case 6:
                    System.out.print("\nDigite o valor para remover: ");
                    int valorRemover = scanner.nextInt();
                    Celula celula = lista.buscaCelula(valorRemover);
                    if (celula != null) {
                        lista.remove(celula);
                        System.out.println("Elemento " + valorRemover + " removido.");
                    } else {
                        System.out.println("Elemento " + valorRemover + " não encontrado na lista.");
                    }
                    break;
                case 7:
                    lista.imprime();
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
