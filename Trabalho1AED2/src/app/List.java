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

    //--------------------------------------------END OF GETTERS AND SETTERS------------------------------------

    
    public void insertFirst(TBlocos tb)// ---------------------INSERT FIRST
    {
        Node newNode = new Node(tb);
        if (this.isEmpity()) {
            this.last = newNode;

        }
        newNode.setNext(this.first);
        this.first = newNode;
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

    public boolean removeNode(int val) {
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

    public String printList() {
        String message = "";
        if (isEmpity()) {
            message = "";
        } else {
            Node current = this.first;
            while (current != null) {
                message += current.getTb().getValor() + " ";
                current = current.getNext();
            }
        }
        return message;
    }

    public boolean search(int val) {
        Node current = this.first;
        while ((current != null)) {
            if (current.getTb().getValor() == val) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }// ---------------------------------------------------------------------SEARCH

    public boolean isLast(int val) {
        if (this.last.getTb().getValor() == val) {
            return true;
        }
        return false;

    }

    public boolean isFirst(int val) {
        if (this.first.getTb().getValor() == val) {
            return true;
        }
        return false;

    }

    public int getAfter(int val) {
        Node current = this.first;
        while (current != null && current.getTb().getValor() != val){
            current = current.getNext();
        }
        if (current.getNext() != null) {
            return current.getNext().getTb().getValor();
        }
        return current.getTb().getValor();

    }

    public Node getSelected(int sel) {
        TBlocos tb = new TBlocos(sel);
        Node newNode = first;

        while ((newNode != null)) {
            if (newNode.getTb().getValor() == sel) {
                return newNode;
            }
            newNode = newNode.getNext();
        }
        return null;

    }

    public Node getNextSelected(int sel) {
        TBlocos tb = new TBlocos(sel);
        Node newNode = first;

        while ((newNode != null)) {
            if (newNode.getTb().getValor() == sel) {
                newNode = newNode.getNext();
                return newNode;
            }
            newNode = newNode.getNext();
        }
        return null;
    }

    public void insertAt(TBlocos tb)// ---------------------INSERT AT
    {
        Node newNode = new Node(tb);
        Node aux = this.first;
        if (aux == null) {
        } else {

            if (aux.getNext() != null) {

                newNode.setNext(aux.getNext());
                aux.setNext(newNode);
            } else {
                aux.setNext(newNode);
                this.setLast(newNode);
            }

        }

    }

}