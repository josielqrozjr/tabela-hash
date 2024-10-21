package hash;

import lista.ListaEncadeada;
import java.util.Random;

public class TabelaHash {
    private int colisao;
    private ListaEncadeada[] tabela;

    // Construtor que instancia a tabela
    public TabelaHash(int tamanho) {
        this.tabela = new ListaEncadeada[tamanho];
        this.colisao = 0;

        // Loop para instanciar cada lista encadeada de acordo com o tamanho da tabela
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }

        preencherTabela();
    }

    // Método padrão de função Hash
    public int funcaoHash(int chave) {
        return chave % this.tabela.length;
    }

    // Método para inserir a chave na tabela
    public void insere(int chave) {
        int indice = funcaoHash(chave);

        if (!tabela[indice].vazia()) {
            colisao++; // Incrementa o número de colisões se já houver um elemento
        }

        tabela[indice].insereOrdenado(chave); // Insere ordenado na lista encadeada
    }

    // Método para preencher a tabela com números inteiros com 90% do tamanho
    private void preencherTabela() {
        Random random = new Random();
        int numElementos = (int) (this.tabela.length * 0.9);

        for (int i = 0; i < numElementos; i++) {
            int chave = random.nextInt(1000000); // Gera os números randômincos
            insere(chave);
        }
    }

    // Método para exibir todos os elementos da tabela
    public void mostrarTabela() {
        for (int i = 0; i < this.tabela.length; i++) {
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
        int indice = chave % this.tabela.length;
        return tabela[indice].busca(chave);
    }

    // Get para o número de colisões
    public int getColisoes() {
        return colisao;
    }
}
