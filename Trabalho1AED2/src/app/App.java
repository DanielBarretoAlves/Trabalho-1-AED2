package app;
//--------------CODE BY DANIEL BARRETO ALVES
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    //--------------------------------------------------------------------------CREATE FILES
    public static void createFile(String content)
    {
        FileWriter arquivo;
        String doc = "saida";

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


    //--------------------------------------------------------------------------GET FILE
    public static String getFile() {
        String content = "";

        // ---------------------------
        try {
            File myObj = new File("src/app/arquivo1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                content += data + ";";

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // ---------------------------

        return content;
    }

    //-----------------------------------------------------------------------------GET WORLD SIZE
    public static int getWorldSize(String file) {
        int size = 0;
        String[] transcript = file.split(";");

        size = Integer.parseInt(transcript[0]);
        return size;

    }// -----------------------------------------------------------WORLD SIZE


    //-----------------------------------------------------------------------------SHOW ALL LIST
    public static String showAllLists(List[] list) {
        String content = "";
        for (int i = 0; i < list.length; i++) {
            content += i + "|" + list[i].printList()+"\n";
        }
        return content;
    }// ------------------------------------------SHOWALLLIST


    //-------------------------------------------------------------------------------CLEAN LIST
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


    //-------------------------------------------------------------------------------GET BIGGEST LIST
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


    //--------------------------------------------------------------------------GET POSITION
    public static int getPos(List[] table, int x) {
        int pos = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i].search(x)) {
                pos = i;
            }
        }
        return pos;
    }


    //--------------------------------------------------------------------------SEND EVERYONE TO ORIGNINAL
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
        sendAllBack(table, a, posA);
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

    //--------------------------------------------------------------------------SEND ABOVE
    public static void sendAbove(List[] table, int a, int b) {
        boolean sent = false;
        int next;
        if (!table[a].isEmpity()) {
            // não pode estar vazia
            if (!table[a].isLast(a)) {
                // o ultimo não é a

                next = table[a].getAfter(a);
                TBlocos tb = new TBlocos(b);
                table[b].insertLast(tb);
                table[a].removeNode(next);
            }
        }

    }


    //------------------------------------------------------------------------------------SEND A PILE
    public static void sendPile(List[] table, int target, int val, int goal) {
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

    //-------------------------------------------------------------------------------INSERT AFTER
    public static void insertAfter(List[] table, int a, int b, int pos) {
        table[pos].removeNode(a);
        TBlocos tb = new TBlocos(a);
        table[b].insertAt(tb);
    }


    //--------------------------------------------------------------------------------READ COMMANDOS
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

    //------------------------------------------------------------------------------------GET COMMANDOS
    public static int[][] getCommando(String file) {
        String[] command = file.split(";");
        int[][] action = new int[command.length][3];
        for (int i = 0; i < command.length; i++) {
            String[] test = command[i].split(" ");
            for (int j = 0; j < test.length; j++) {
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
                    i = command.length;
                    break;
                    
                }
            }
        }
        return action;

    }

    public static void main(String[] args) {

        List[] table = new List[getWorldSize(getFile())];
        for (int i = 0; i < table.length; i++) {
            table[i] = new List();
            TBlocos tb = new TBlocos(i);
            table[i].insertLast(tb);
        }

         int[][] test = getCommando(getFile());
         readCommando(test, table);

        createFile(showAllLists(table));
        System.exit(0);

       
    }

}