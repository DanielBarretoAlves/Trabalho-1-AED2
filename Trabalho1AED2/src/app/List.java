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

    public void insertFirst(TBlocos tb)// ---------------------INSERT FIRST
    {
        Node newNode = new Node(tb);
        if (isEmpity()) {
            this.last = newNode;

        }
        newNode.setNext(this.first);
        this.qtd++;

    }

    public boolean isEmpity() {
        return (this.first == null);
    }// -------------IS EMPITY

    public void insertLast(TBlocos tb) {
        Node newNode = new Node(tb);
        if (isEmpity()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);

        }
        this.last = newNode;
        this.qtd++;

    }

    public boolean removeNode(int val)
    {
        Node current = this.first;
        Node preview = null;
        if (isEmpity()) {
            return false;
        } else {
            while (current != null && (current.getTb().getValor() != val)) {
                preview = current;
                current = current.getNext();
            }
            if (current == this.first) {
                if (first == last) {
                    this.last = null;
                }
                this.first = this.first.getNext();
            } else {
                if (current == this.last) {
                    this.last = preview;
                }
                preview.setNext(current.getNext());
            }
            this.qtd--;
            return true;
        }
    }

    public String printList()
    {
        String message ="";
        if (isEmpity()) {
            message = "";
        }else{
            Node current = this.first;
            while (current != null)
            {
                message += current.getTb().getValor() + " ";
                current = current.getNext();
            }
        }
        return message;
    }

    public boolean search(int val){
        Node current = this.first;
        while ((current != null))  {
            if (current.getTb().getValor() == val) {
                return true;
            }
            current = current.getNext();
        }
        return false;
        
    }//---------------------------------------------------------------------SEARCH

   


}