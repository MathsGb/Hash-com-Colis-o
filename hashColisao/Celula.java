package hashColisao;

public class Celula {
    private int numero;
    private int indiceProx = -2;
    
    public Celula(int numero) {
        this.numero = numero;
        this.indiceProx = (-1);
    }

    public int getNumero(){
        return this.numero;
    }

    public int getIndiceProx(){
        return this.indiceProx;
    }

    public int setNumero(int chave){
        return this.numero = chave;
    }

    public int setIndiceProx(int chave){
        return this.indiceProx = chave;
    }

}
