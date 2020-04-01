package app;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class App {
    public static int getNumberOfRows(){//------------NUMBER OF ROWS
        int index = 0;
        int numberOfRows = 0;
        try {
            File myObj = new File("src/app/file.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (index == 0) {
                    numberOfRows += Double.parseDouble(data);
                    
                }
                index++;

                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return numberOfRows;
    }

    public static void setAllLists(List[] table)
    {
        for(int i = 0; i < table.length; i++)
        {
            switch (i) {
                case 0:
                List list1 = new List();
                    TBlocos tb1 = new TBlocos(0);
                    list1.insertLast(tb1);
                    TBlocos tb2 = new TBlocos(4);
                    list1.insertLast(tb2);
                    TBlocos tb3 = new TBlocos(2);
                    list1.insertLast(tb3);
                    break;
                    case 1:
                    List list2 = new List();
                    

            
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfRows());
        List[] tabletop = new List[getNumberOfRows()];
    }
}
