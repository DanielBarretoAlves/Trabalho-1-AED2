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

    public static int getPos(List[] table, int x)
    {
        int pos=0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].search(x)) {
                pos = i;
            }
        }
        return pos;
    }

    public static void pileOver(List[] table, int a, int b) {
        System.out.println("pile " +a+ " over " +b);
        int posB =getPos(table, b);

        while (!table[a].isLast(a) && (!table[a].isEmpity())) {
            // System.out.println("entrou no loop");
            int next = a;
            if (table[a].getLast() != null) {
                 next = table[a].getAfter(a);
                //  System.out.println("entrou no if next é " + next);
            }
            TBlocos tb = new TBlocos(next);
            table[posB].insertAt(tb);
            // System.out.println("Inseriu na table b "+table[b].printList());
            table[a].removeNode(next);

        }
         TBlocos tb = new TBlocos(a);
         table[posB].insertAt(tb);
         table[a].removeNode(a);
    }

    public static void pileOnto(List[] table, int a, int b) {
        System.out.println("pile " +a+" onto " +b);
        int posB = getPos(table, b);
        while (!table[posB].isLast(b)) {
            // verificando removendo e reposicionando os elementos adjacentes
            int last = table[posB].getLast().getTb().getValor();
            TBlocos tb = new TBlocos(last);
            table[last].insertFirst(tb);
            table[b].removeNode(last);
        }
        while (!table[a].isLast(a)) {
            int last = table[a].getLast().getTb().getValor();
            TBlocos tb = new TBlocos(last);
            table[posB].insertAt(tb);
        }
        table[a].removeNode(a);
        TBlocos tb = new TBlocos(a);
        table[posB].insertAt(tb);

    }

    public static void sendAbove(List[] table, int a, int b) {
        boolean sent = false;
        int next;
        if (!table[a].isEmpity()) {
            // não pode estar vazia
            if (!table[a].isLast(a)) {
                // o ultimo não é a

                next = table[a].getAfter(a);
                // System.out.println("hey "+next);
                TBlocos tb = new TBlocos(b);
                table[b].insertLast(tb);
                table[a].removeNode(next);
            }
        }

    }

    public static void insertAfter(List[] table, int a, int b, int pos) {
        table[pos].removeNode(a);
        TBlocos tb = new TBlocos(a);
        table[b].insertAt(tb);
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
        // moveOver(4, 0, table);
        showAllLists(table);
        System.out.println("-----------------------");
       
        showAllLists(table);
        // pileOver(table, 2, 0);
        pileOnto(table, 0, 3);
        pileOver(table, 3, 2);
        pileOver(table, 4, 2);
        pileOver(table, 1, 2);

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