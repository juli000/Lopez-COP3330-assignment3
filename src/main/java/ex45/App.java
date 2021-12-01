package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        //Create file to read in lines from the input text
        File f = new File("src/main/java/ex45/exercise45_input.txt");
        Scanner s = new Scanner(f);

        //Create scanner for user input of file name
        Scanner u = new Scanner(System.in);
        System.out.println("Output file name: ");
        String fileName = u.nextLine();

        //Create file name with given user input
        FileWriter fw = new FileWriter("src/main/java/ex45/" + fileName);

        //go through each line and replace the word and then print it into the new output file
        try{
            while(s.hasNextLine()) {
                String old = s.nextLine();
                old = replaceUtilize(old);
                fw.write(old + "\n");
            }
        }
        //close both scanners
        finally {
            s.close();
        }
        fw.close();
    }

    public static String replaceUtilize(String s){
        s = s.replace("utilize", "use");
        return s;
    }
}
