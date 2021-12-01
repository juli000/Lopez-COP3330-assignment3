package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //creates required header listed in problem
        System.out.printf("%-10s%-10s%-10s\n", "Last", "First", "Salary");
        System.out.print("--------------------------\n");

        //printing people with salaries in tabular format
        printPeople("src/main/java/ex42/exercise42_input.txt");
    }

    public static void printPeople(String fname){
        try{
            //creates File for input and use of scanner to be able to read input
            File f = new File(fname);
            Scanner s = new Scanner(f);

            //while there is still lines in input file it will split each line according to the comma and print them in the tabular format
            while(s.hasNextLine()){
                String p = s.nextLine();
                String[] temp = p.split(",");
                System.out.printf("%-10s%-10s%-10s\n", temp[0], temp[1], temp[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
