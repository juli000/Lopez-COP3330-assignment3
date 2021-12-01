package ex46;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws IOException {
        //Using scanner to read in the input file
        Scanner fileScanner = new Scanner(new File("src/main/java/ex46/exercise46_input.txt"));

        //Using a treemap in order to be able to easier assign values to each word
        //The use of a treemap allows for sorting automatically according to the amount of times it appears or key
        Map<String, Integer> c = new TreeMap<String, Integer>();

        //while there is another line of words this loop will continue
        while(fileScanner.hasNextLine()){
            String s = fileScanner.next();
            if(c.containsKey(s)){
                c.put(s,c.get(s)+1);
            }else{
                c.put(s,1);
            }
        }

        //For each word print it out then print each * according to the treemap
        for(String str:c.keySet()){
            System.out.printf("%-10s",str+":");
            for(int i = c.get(str);i > 0;i--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static String printN(Map<String, Integer> c, String str){
        String s = "";
        for(int i = c.get(str);i > 0;i--){
            s += "*";
        }
        return s;
    }

}
