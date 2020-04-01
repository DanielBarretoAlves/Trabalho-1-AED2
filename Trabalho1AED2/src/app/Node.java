package app;

public class Node {
    private TBlocos tb;
    private Node next;
    
    public Node(TBlocos tb)
    {
        this.tb = tb;
        this.next = null;
    }

    public TBlocos getTb() {
        return tb;
    }

    public void setTb(TBlocos tb) {
        this.tb = tb;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {//-----------------------------------------------------GETTS E SETTERS
        this.next = next;
    }

    


}