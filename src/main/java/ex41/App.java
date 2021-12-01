/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

package ex41;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //Create Scanner for input text which allows us to read it
        Scanner f = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));

        //read from input file into ArrayList<String> called People
        ArrayList<String> people = new ArrayList<>();
        inputPeople(f, people);

        //Sort using a case-insensitive order alphabetically
        people.sort(String.CASE_INSENSITIVE_ORDER);
        f.close();

        //writing the data to the output file with error exception printing to console
        try{
            printPeople(people);
        }
        catch (Exception e){
            System.out.println("Error occurred.");
        }
    }

    //reads people from the input file to an ArrayList of Strings named people
    public static void inputPeople(Scanner f, ArrayList<String> people){
       //reads each individual line until there is no more
        while(f.hasNextLine()){

            //adds each line as a person to the people ArrayList
            people.add(f.nextLine());
        }
    }

    //prints people to the output file
    public static void printPeople(ArrayList<String> people) throws IOException{

        //Using FileWriter to create the output file
        FileWriter output = new FileWriter("exercise41_output.txt");

        //Required Header for Output file
        output.write("Total of " + people.size() + " names\n");
        output.write("----------------\n");

        //printing each person per line
        for (String person : people) {
            output.write(person + "\n");
        }
        output.close();
    }
}
