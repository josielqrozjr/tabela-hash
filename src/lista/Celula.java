package lista;

public class Celula {
    private Integer elemento;
    private Celula proximo;

    // Construtor padrão
    public Celula() {
        this.elemento = null;
        this.proximo = null;
    }

    // Construtor com elemento
    public Celula(Integer elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    // Gets e Sets da classe
    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Integer getElemento() {
        return elemento;
    }
}
