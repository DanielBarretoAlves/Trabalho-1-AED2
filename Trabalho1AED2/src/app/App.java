package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public static void moveRobot(int a, int b, int action)
    {
        switch (action) {
            case 1 :

            
                
                break;
        
            default:
                break;
        }
    }

    public static void getCommando(String file) {
        String[] command = file.split(";");
        for (int i = 0; i < command.length; i++) {
            String[] test = command[i].split(" ");
            for (int j = 0; j < test.length; j++) {
                System.out.println(test[j]);
                if (test[j].contains("move")) {
                    if (test[j+2].contains("over")) {
                         int a = Integer.parseInt(test[j+1]);
                         int b = Integer.parseInt(test[j+3]);
                         int action = 1;
                         

                    }
                }
            }
        }


    }//-----------------------------------------GETCOMMANDO

    // return command;
    

    public static void main(String[] args) {

        getCommando(getFile());
        List[] table = new List[getWorldSize(getFile())];
        for (int i = 0; i < table.length; i++) {
            List list = new List();
            TBlocos tb = new TBlocos(i);
            list.insertLast(tb);
            table[i] = list;
        }

        // showAllLists(table);
        // System.out.println(getFile().length());

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