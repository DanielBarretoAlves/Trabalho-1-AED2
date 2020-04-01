package app;

public class List {
    private Node first;
    private Node last;
    private int qtd;

    public List() {
        this.first = null;
        this.last = null;
        this.qtd = 0;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void insertFirst(TBlocos tb)//---------------------INSERT FIRST
    {
        Node newNode = new Node(tb);
        if (isEmpity()) {
            this.last = newNode;

        }
        newNode.setNext(this.first);
        this.qtd++;

    }

    public boolean isEmpity(){return(this.first == null);}//-------------IS EMPITY

    

    
}