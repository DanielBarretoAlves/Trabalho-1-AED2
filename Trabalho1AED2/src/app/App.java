package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void createFile(String content)
    {
        FileWriter arquivo;
        String doc = "saida";

		//Check 
		File f = new File("src/app"+doc + ".txt");
		if (f.exists() && !f.isDirectory()) {

			try {
				arquivo = new FileWriter(new File(doc+".txt"));
				arquivo.write(content);
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				arquivo = new FileWriter(new File(doc+".txt"));
				arquivo.write(content);
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

    public static String getFile() {
        String content = "";

        // ---------------------------
        try {
            File myObj = new File("src/app/arquivo1.txt");
            Scanner myReader = new Scanner(myObj);
            // int index =0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                // System.out.println(data);
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
        // System.out.println("Size: " +size);

        return size;

    }// -----------------------------------------------------------WORLD SIZE

    public static String showAllLists(List[] list) {
        String content = "";
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + "|" + list[i].printList());
            content += i + "|" + list[i].printList()+"\n";
        }
        return content;
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

    public static int getBigggestList(List[] table)
    {
        int s = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].getQtd() > s) {
                s = table[i].getQtd();
            }
            
        }
        return s;
    }

    public static int getPos(List[] table, int x) {
        int pos = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].search(x)) {
                pos = i;
            }
        }
        return pos;
    }

    public static void sendAllBack(List[] table, int x, int target) {

        if (!table[target].isEmpity() && (!table[target].isLast(target))) {

            while (table[target].getFirst().getTb().getValor() != table[target].getLast().getTb().getValor()) {
                int last = table[target].getLast().getTb().getValor();
                TBlocos tb = new TBlocos(last);
                table[last].insertFirst(tb);
                table[x].removeNode(last);
            }
        }

    }

    public static void moveOnto(List[] table, int a, int b)// -----------MOVEONTO
    {
        int posA = getPos(table, a);
        int posB = getPos(table, b);
        // Passo 1 tirar tudo de cima do a
        sendAllBack(table, a, posA);
        // Passo 2 tirar tudo de cima do b
        sendAllBack(table, b, posB);
        TBlocos tb = new TBlocos(a);
        table[posB].insertLast(tb);
        table[posA].removeNode(a);
    }

    public static void moveOver(List[] table, int a, int b)// -----------MOVEOVER
    {
        int posA = getPos(table, a);
        int posB = getPos(table, b);
        // Passo 1 tirar tudo de cima do a
        sendAllBack(table, a, posA);
        TBlocos tb = new TBlocos(a);
        table[posB].insertLast(tb);
        table[posA].removeNode(a);
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

    public static void sendPile(List[] table, int target, int val, int goal) {
        // System.out.println(table[target].getLast().getTb().getValor());
        TBlocos tb = new TBlocos(val);
        table[goal].insertLast(tb);
        while (table[target].getLast().getTb().getValor() != target) {

            int sender = table[target].getLast().getTb().getValor();
            TBlocos tb1 = new TBlocos(sender);
            table[goal].insertLast(tb1);
            table[target].removeNode(sender);
        }
    }

    public static void pileOnto(List[] table, int a, int b)// -------------------------PILE ONTO
    {
        int posA = getPos(table, a);
        int posB = getPos(table, b);
        // Passo A limpar o b
        sendAllBack(table, b, posB);
        sendPile(table, posA, a, posB);
        table[a].removeNode(a);
    }

    public static void pileOver(List[] table, int a, int b)// -------------------------PILE OVER
    {
        int posA = getPos(table, a);
        int posB = getPos(table, b);
        sendPile(table, posA, a, posB);
        table[a].removeNode(a);
        

    }

    public static void insertAfter(List[] table, int a, int b, int pos) {
        table[pos].removeNode(a);
        TBlocos tb = new TBlocos(a);
        table[b].insertAt(tb);
    }

    public static void readCommando(int[][] commandos, List[] table) {
        for (int i = 0; i < commandos.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0 && i > 0 && i < (commandos.length - 1)) {
                    switch (commandos[i][j]) {
                        case 1:
                            moveOver(table, commandos[i][1], commandos[i][2]);

                            break;
                        case 2:
                            moveOnto(table, commandos[i][1], commandos[i][2]);

                            break;
                        case 3:
                            pileOver(table, commandos[i][1], commandos[i][2]);

                            break;
                        case 4:
                            pileOnto(table, commandos[i][1], commandos[i][2]);

                            break;

                        default:
                            break;
                    }
                }
            }
        }
    }

    public static int[][] getCommando(String file) {
        String[] command = file.split(";");
        int[][] action = new int[command.length][3];
        for (int i = 0; i < command.length; i++) {
            String[] test = command[i].split(" ");
            for (int j = 0; j < test.length; j++) {
                // System.out.println(test[j]);
                if (i == 0) {
                    action[i][0] = 9;
                }
                if (test[j].contains("move")) {
                    if (test[j + 2].contains("over")) {
                        int a = Integer.parseInt(test[j + 1]);
                        int b = Integer.parseInt(test[j + 3]);
                        action[i][0] = 1;
                        action[i][1] = a;
                        action[i][2] = b;
                    } else if (test[j + 2].contains("onto")) {
                        int a = Integer.parseInt(test[j + 1]);
                        int b = Integer.parseInt(test[j + 3]);
                        action[i][0] = 2;
                        action[i][1] = a;
                        action[i][2] = b;
                    }
                } else if (test[j].contains("pile")) {
                    if (test[j + 2].contains("over")) {
                        int a = Integer.parseInt(test[j + 1]);
                        int b = Integer.parseInt(test[j + 3]);
                        action[i][0] = 3;
                        action[i][1] = a;
                        action[i][2] = b;
                    } else if (test[j + 2].contains("onto")) {
                        int a = Integer.parseInt(test[j + 1]);
                        int b = Integer.parseInt(test[j + 3]);
                        action[i][0] = 4;
                        action[i][1] = a;
                        action[i][2] = b;
                    }
                } else if (test[j].contains("quit")) {

                    action[i][0] = 9;
                    break;
                }
            }
        }
        return action;

    }

    public static void main(String[] args) {

        // TBlocos tb = new TBlocos(1);

        // list.printList();
        // getCommando(getFile());
        List[] table = new List[getWorldSize(getFile())];
        for (int i = 0; i < table.length; i++) {
            table[i] = new List();
            TBlocos tb = new TBlocos(i);
            table[i].insertLast(tb);
        }

        //  moveOnto(table, 4, 0);
        //  moveOnto(table, 1, 2);
        //  moveOver(table, 2, 0);
        //  moveOver(table, 3, 1);
        // // showAllLists(table);
        // pileOnto(table, 1, 0);
        // showAllLists(table);

        //------------------------------------------
         int[][] test = getCommando(getFile());
         readCommando(test, table);
        //  showAllLists(table);
        //----------------------------------------------

        // System.out.println(getFile());
        createFile(showAllLists(table));

        // for (int i = 0; i < test.length; i++) {
        // for (int j = 0; j < 3; j++) {
        // System.out.print(test[i][j]);
        // }
        // System.out.println(" ");
        // }

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

