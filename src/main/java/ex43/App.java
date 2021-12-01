package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Scanner for user input
        Scanner s = new Scanner(System.in);

        //Variables to hold user information
        String websiteName;
        String name;
        String path;
        char js = 'N';
        char css = 'N';

        //Assigning each variable with user given information
        System.out.print("Site name: ");
        websiteName = s.nextLine();
        System.out.print("Author: ");
        name = s.nextLine();
        System.out.print("Do you want a folder for JavaScript?");
        js = s.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = s.next().charAt(0);

        //Get the path to the directory for later use
        path = System.getProperty("user.dir");
        path += "\\" + websiteName;

        //Create directory where files will be held
        File website = new File(path);
        boolean siteMade = website.mkdir();

        //Create the files required given user input using .write statements
        if(siteMade){
            System.out.println("Created " + path);
            try{
                FileWriter filemaker = new FileWriter(new File(path + "\\index.html"));
                createIndex(filemaker,name, websiteName);
                System.out.println("Created " + path + "\\index.html");
                if(js == 'Y' || js == 'y'){
                    File jsFolder = new File(path + "\\js");
                    boolean jsMade = jsFolder.mkdir();
                    if(jsMade){
                        System.out.println("Created" + jsFolder + "\\");
                    }
                    else{
                        System.out.println("Js folder not created.");
                    }
                }
                if(css == 'Y' || css == 'y'){
                    File cssFolder = new File(path + "\\css");
                    boolean cssMade = cssFolder.mkdir();
                    if(cssMade){
                        System.out.println("Created" + cssFolder + "\\");
                    }
                    else{
                        System.out.println("Css folder not created.");
                    }
                }
                //Exceptions in case files could not be made properly
            } catch (IOException e) {
                System.out.println("index.html could not be made correctly.");
            }
        }
        //exception in case directory could not be made correctly
        else{
            System.out.println("Folder not made.");
        }
        s.close();
    }

    public static String createIndex(FileWriter filemaker, String name, String websiteName) throws IOException {
        filemaker.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
        filemaker.write("\t<meta author=\"" + name + "\">\n");
        filemaker.write("\t<title>" + websiteName + "</title>\n");
        filemaker.write("</head?\n<body>\n\n</body>\n</html>");
        filemaker.close();
        return "DONE";
    }
}
