package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class App {

    public static String getFile() {
        String content = "";

        // ---------------------------
        try {
            File myObj = new File("src/app/file.txt");
            Scanner myReader = new Scanner(myObj);
            // int index =0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                // size = Integer.parseInt(data);
                content += data + ";";
                // return size;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // ---------------------------

        return content;
    }

    public static int getWorldSize(String file) {
        int size = 0;
        String[] transcript = file.split(";");

        size = Integer.parseInt(transcript[0]);

        return size;

    }// -----------------------------------------------------------WORLD SIZE

    public static void showAllLists(List[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + "|" + list[i].printList());
        }
    }// ------------------------------------------SHOWALLLIST

    public static void cleanList(List[] table, int val, int pos) {
        boolean cleaned = false;
        while (cleaned != true) {
            if (table[val].getLast().getTb().getValor() != val) {
                int posA = table[val].getLast().getTb().getValor();
                table[val].removeNode(posA);
                TBlocos tb = new TBlocos(posA);
                table[posA].insertFirst(tb);
            } else {
                cleaned = true;
            }
        }

    }
    
    public static void pileOver2(List[] table, int a, int b)
    {
        System.out.println("entrou");
        if (!table[a].isEmpity()) {
            System.out.println("n e´vazio");
            int next;
            boolean done = false;
            while (done != true) {
                System.out.println("entrou no loop");
                if (!table[a].isLast(a)) {
                    System.out.println("a n é o ultimo");
                   next = table[a].getAfter(a);
                   TBlocos tb = new TBlocos(next);
                   table[b].insertLast(tb);
                   table[a].removeNode(next);
                }else{
                    TBlocos tb = new TBlocos(a);
                    table[b].insertLast(tb);
                   table[a].removeNode(a);
                    done = true;
                }
                
            }
            
        }
    }
    public static void sendAbove(List[] table, int a, int b) {
        boolean sent = false;
        int next;
        if (!table[a].isEmpity()) {
            //não pode estar vazia
            if (!table[a].isLast(a)) {
                //o ultimo não é a
                
                next = table[a].getAfter(a);
                // System.out.println("hey "+next);
                TBlocos tb = new TBlocos(b);
                table[b].insertLast(tb);
                table[a].removeNode(next);
            }
        }
        
    }

    public static void insertAfter(List[] table, int a, int b, int pos)
    {
        table[pos].removeNode(a);
        TBlocos tb = new TBlocos(a);
        table[b].insertAt(tb);
    }
    public static void pileOver(int a, int b, List[] table) {
        int listA = 0, listB = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].search(a)) {
                listA = i;
            }
            if (table[i].search(b)) {
                listB = i;
            }
        }
        // insertAfter(table, a, b,listA);
        sendAbove(table, a, b);
    }

    public static void pileOnto(int a, int b, List[] table) {
        int i = 0;
        int aPos;
        System.out.println("pile " + a + " onto " + b);
        System.out.println("----------------------------------------------");
        while (i < table.length) {
            // System.out.println("Val i : " + i);
            if (table[i].search(a)) {

                if (a == table[i].getLast().getTb().getValor()) {
                    table[i].removeNode(a);
                } else {
                    // System.out.println("A não é igual ao ultimo");
                    int pos = table[i].getLast().getTb().getValor();
                    table[i].getLast();
                    // cleanList(table, a, pos);
                    // TODO: Tudo que está em cima volta
                    sendAbove(table, a, b);

                    aPos = i;

                    table[i].removeNode(a);
                    // casa que era antes e valor

                }

            }
            if (table[i].search(b)) {
                // System.out.println("b is true in " + i);
                TBlocos tb = new TBlocos(a);
                if (table[i].getLast().getTb().getValor() == b) {

                } else {
                    cleanList(table, b, i);

                }
                table[i].insertLast(tb);

            }
            i++;
        }

    }

    public static void moveOnto(int a, int b, List[] table) {
        int i = 0;
        System.out.println("Move " + a + " onto " + b);
        System.out.println("----------------------------------------------");
        while (i < table.length) {
            // System.out.println("Val i : " + i);
            if (table[i].search(a)) {
                // System.out.println("Search is " + table[i].search(a));
                // System.out.println("it will remove " +a);
                // TOTHINK table[i].removeNode(a);
                // System.out.println("Onde Apagar: "+ table[i].printList());
                // System.out.println("VAl" + a);
                // System.out.println("Home " + i);
                // System.out.println("Last "+ table[i].getLast().getTb().getValor());
                if (a == table[i].getLast().getTb().getValor()) {
                    // System.out.println("A é igual ao ultimo do " + i);
                    table[i].removeNode(a);
                } else {
                    // System.out.println("A não é igual ao ultimo");
                    int pos = table[i].getLast().getTb().getValor();
                    table[i].getLast();
                    cleanList(table, a, pos);

                    table[i].removeNode(a);
                    // casa que era antes e valor

                }

            }
            if (table[i].search(b)) {
                // System.out.println("b is true in " + i);
                TBlocos tb = new TBlocos(a);
                if (table[i].getLast().getTb().getValor() == b) {

                } else {
                    cleanList(table, b, i);

                }
                table[i].insertLast(tb);

            }
            i++;
        }

    }

    public static void moveOver(int a, int b, List[] table) {
        int i = 0;
        System.out.println("Move " + a + " over " + b);
        System.out.println("----------------------------------------------");
        while (i < table.length) {
            // System.out.println("Val i : " + i);
            if (table[i].search(a)) {
                // System.out.println("Search is " + table[i].search(a));
                // System.out.println("it will remove " +a);
                // TOTHINK table[i].removeNode(a);
                // System.out.println("Onde Apagar: "+ table[i].printList());
                // System.out.println("VAl" + a);
                // System.out.println("Home " + i);
                // System.out.println("Last "+ table[i].getLast().getTb().getValor());
                if (a == table[i].getLast().getTb().getValor()) {
                    // System.out.println("A é igual ao ultimo do " + i);
                    table[i].removeNode(a);
                } else {
                    // System.out.println("A não é igual ao ultimo");
                    int pos = table[i].getLast().getTb().getValor();
                    table[i].getLast();
                    cleanList(table, a, pos);
                    table[i].removeNode(a);
                    // casa que era antes e valor

                }
                // System.out.println("i = " + i + " A Val: " + a);

                // if (!table[i].isEmpity()) {

                // System.out.println("Table is not empity");
                // // ------------------------FOCUS TODO
                // if (table[i].getLast().getTb().getValor() == a) {
                // System.out.println("É Igual");
                // } else {

                // cleanList(table, a);
                // }
                // }
            }
            if (table[i].search(b)) {
                // System.out.println("b is true in " + i);
                TBlocos tb = new TBlocos(a);
                table[i].insertLast(tb);

            }
            i++;
        }

    }

    public static void getCommando(String file) {
        String[] command = file.split(";");
        for (int i = 0; i < command.length; i++) {
            String[] test = command[i].split(" ");
            for (int j = 0; j < test.length; j++) {
                // System.out.println(test[j]);
                if (test[j].contains("move")) {
                    if (test[j + 2].contains("over")) {
                        int a = Integer.parseInt(test[j + 1]);
                        int b = Integer.parseInt(test[j + 3]);
                        int action = 1;
                    }
                }
            }
        }

    }// -----------------------------------------GETCOMMANDO

    // return command;

    public static void main(String[] args) {

        // TBlocos tb = new TBlocos(1);

        // list.printList();
        getCommando(getFile());
        List[] table = new List[getWorldSize(getFile())];
        for (int i = 0; i < table.length; i++) {
            table[i] = new List();
            TBlocos tb = new TBlocos(i);
            table[i].insertLast(tb);
            // System.out.println(table[i].printList());
        }
        // System.out.println("Hello " +table[0].getLast().getTb().getValor());
        // moveOver(1, 2, table);
        moveOver(4, 0, table);
        showAllLists(table);
        System.out.println("-----------------------");
        moveOver(1, 2, table);
        showAllLists(table);
        pileOver2(table, 2, 0);
        showAllLists(table);

    }

}

// str1.contains("example")

// String myStr = "Hello";
// System.out.println(myStr.startsWith("Hel"));
// System.out.println(myStr.startsWith("llo"));
// System.out.println(myStr.startsWith("o"));
// }
// }

// COMMAND TABLE
// Move Onto = tudo que esta em cima dos dois volta
// Move over = tudo que está em cima do A volta
// Pile Onto = oq está no b volta
// Pile over = poem a sobre b sem voltar ninguem

// move = 1
// pile = 2
// over = 1
// onto = 2