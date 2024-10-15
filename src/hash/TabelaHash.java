package hash;

import lista.ListaEncadeada;
import java.util.Random;
import java.util.Scanner;

public class TabelaHash {
    private int colisao;
    private ListaEncadeada[] tabela;
    private int tamanho;

    // Construtor que inicializa a tabela com o tamanho passado e inicializa colisões
    public TabelaHash(int tam) {
        this.tamanho = tam;
        this.tabela = new ListaEncadeada[tam];
        this.colisao = 0;

        for (int i = 0; i < tam; i++) {
            tabela[i] = new ListaEncadeada(); // Inicializando cada lista encadeada
        }

        preencherTabela();
    }

    // Método para inserir a chave na tabela
    public void insere(int chave) {
        int indice = chave % tamanho;

        if (!tabela[indice].vazia()) {
            colisao++; // Incrementa o número de colisões se já houver um elemento
        }

        tabela[indice].insereOrdenado(chave); // Insere na lista encadeada correspondente
    }

    // Método para preencher a tabela com números inteiros (90% do tamanho)
    private void preencherTabela() {
        Random random = new Random();
        int numElementos = (int) (tamanho * 0.9); // 90% do tamanho

        for (int i = 0; i < numElementos; i++) {
            int chave = random.nextInt(1000000); // Gera um número de 0 a 1 milhão
            insere(chave);
        }
    }

    // Método para exibir todos os elementos da tabela
    public void mostrarTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
            if (tabela[i].vazia()) {
                System.out.println("-1");
            } else {
                tabela[i].imprime();
            }
        }
    }

    // Método de busca que retorna true se a chave existir
    public boolean busca(int chave) {
        int indice = chave % tamanho;
        return tabela[indice].busca(chave);
    }

    // Get para o número de colisões
    public int getColisoes() {
        return colisao;
    }

    // Main para testar a implementação
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho da tabela:");
        int tam = scanner.nextInt();
        TabelaHash tabela = new TabelaHash(tam);

        while (true) {
            System.out.println("Digite uma chave para buscar (ou -1 para sair):");
            int chave = scanner.nextInt();
            if (chave == -1) break;

            if (tabela.busca(chave)) {
                System.out.println("Chave " + chave + " encontrada.");
            } else {
                System.out.println("Chave " + chave + " não encontrada.");
            }
        }

        tabela.mostrarTabela();
        System.out.println("Número de colisões: " + tabela.getColisoes());
        scanner.close();
    }
}

