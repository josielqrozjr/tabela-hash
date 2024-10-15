package lista;

public class ListaEncadeada {
    private Celula lista;

    public ListaEncadeada() {
        this.lista = null;
    }

    public Celula getPrimeiro() {
        return lista;
    }

    // Verifica se a lista atual está vazia com retorno True ou False
    public boolean vazia() {
        return lista == null;
    }

    // Insere um novo elemento no início da lista
    public void inserePrimeiro(int info) {
        Celula novaCelula = new Celula(info);
        novaCelula.setProximo(this.lista);
        this.lista = novaCelula;
    }

    // Insere um novo elemento logo após a célula fornecida
    public void insereDepois(Celula celulaAtual, int info) {
        if (celulaAtual != null) {
            Celula novaCelula = new Celula(info);
            novaCelula.setProximo(celulaAtual.getProximo());
            celulaAtual.setProximo(novaCelula);
        }
    }

    // Insere o elemento como o último na lista
    public void insereUltimo(int info) {
        Celula novaCelula = new Celula(info);
        if (lista == null) {
            lista = novaCelula;
        } else {
            Celula atual = lista;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novaCelula);
        }
    }

    // Insere o elemento de maneira ordenada na lista
    public void insereOrdenado(int info) {
        Celula novaCelula = new Celula(info);
        if (lista == null || lista.getElemento() >= info) {
            novaCelula.setProximo(lista);
            lista = novaCelula;
        } else {
            Celula atual = lista;
            while (atual.getProximo() != null && atual.getProximo().getElemento() < info) {
                atual = atual.getProximo();
            }
            novaCelula.setProximo(atual.getProximo());
            atual.setProximo(novaCelula);
        }
    }

    // Imprime todos os elementos da lista
    public void imprime() {
        Celula atual = lista;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    // Remove o primeiro elemento da lista e retorna a célula removida
    public Celula removePrimeiro() {
        if (lista == null) {
            return null;
        }
        Celula removida = lista;
        lista = lista.getProximo();
        removida.setProximo(null);
        return removida;
    }

    // Remove o último elemento da lista e retorna a célula removida
    public Celula removeUltimo() {
        if (lista == null) {
            return null;
        }
        if (lista.getProximo() == null) {
            Celula removida = lista;
            lista = null;
            return removida;
        }
        Celula atual = lista;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
        Celula removida = atual.getProximo();
        atual.setProximo(null);
        return removida;
    }

    // Remove uma célula específica da lista e retorna a célula removida
    public Celula remove(Celula celula) {
        if (lista == null || celula == null) {
            return null;
        }
        if (lista == celula) {
            return removePrimeiro();
        }
        Celula atual = lista;
        while (atual.getProximo() != null && atual.getProximo() != celula) {
            atual = atual.getProximo();
        }
        if (atual.getProximo() == null) {
            return null;
        }
        Celula removida = atual.getProximo();
        atual.setProximo(atual.getProximo().getProximo());
        removida.setProximo(null);
        return removida;
    }

    // Buscar o elemento espeficificado
    public Celula buscaCelula(int valor) {
        Celula atual = this.lista;
        while (atual != null) {
            if (atual.getElemento() == valor) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    // Método para buscar um elemento na lista
    public boolean busca(int valor) {
        Celula atual = lista;
        while (atual != null) {
            if (atual.getElemento() == valor) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }
}
