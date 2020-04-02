package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static int getWorldSize()
    {
        int size=0;
        try {
            File myObj = new File("src/app/file.txt");
            Scanner myReader = new Scanner(myObj);
            int index =0;
            while (myReader.hasNextLine()) {
                if (index==0) {
                    String data = myReader.nextLine();
                    size = Integer.parseInt(data);
                    myReader.close();
                    return size;
                }
                
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return size;

    }
    public static void main(String[] args) {
        System.out.println(getWorldSize());
    }

}

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