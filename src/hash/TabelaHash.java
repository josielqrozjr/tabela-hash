package hash;

import java.util.Scanner;
import lista.ListaEncadeada;

public class TabelaHash {
    private int colisao;
    private ListaEncadeada[] tabela;

    public TabelaHash(int tamanho) {
        this.tabela = new ListaEncadeada[tamanho];
        this.colisao = 0;
    }

    public int tamanhoTabela() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int funcaoHash(int chave) {
        return chave % this.tabela.length;
    }

    
}
