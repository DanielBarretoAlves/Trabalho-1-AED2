package app;

public class No {

    private TBlocos tb;
    private No prox;

    public No(TBlocos tb)
    {
        this.tb = tb;
        this.prox = null;
    }//----------------------Constructor

    public TBlocos getP() {
        return tb;
    }

    public void setP(TBlocos p) {
        this.tb = p;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
}