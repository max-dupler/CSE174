//Max Dupler
//CSE 174 Section C
//Assignment 2
//5 October 2021

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Assignment2 {
    public static void main(String[] args) throws FileNotFoundException {
        //get input file from user and initialize scanner
        System.out.print("Enter an input file name: ");
        Scanner in = new Scanner(System.in);
        String inputFile = in.next();
        
        //make file and scanner
        File input = new File(inputFile);
        Scanner fileReader = new Scanner(input);
        
        //start to scan and print letters
        String statement = "";
        
        boolean firstWord = true;
        
        
        while (fileReader.hasNext()) {
            if (fileReader.hasNextInt()) {
                int numLetters = fileReader.nextInt();
                String word = "";
                
                if (firstWord) {
                    firstWord = false;
                } else {
                    statement = statement + " ";
                }
                
                for (int i = 0; i < numLetters; i++) {
                    String nextLetter = fileReader.next();
                    word = word + nextLetter;
                }
                statement = statement + word;
            } else if (fileReader.next().equals("#")) {
                firstWord = true;
                statement = statement + "\n";
            } 
        }
                    
        System.out.print(statement);
        System.out.println();
                        
        //make loop to print or not print file in another file
        
        String choice = "";
        
        while (!choice.equals("y") && !choice.equals("n")) {
            System.out.print("Do you want to print in a file (y/n): ");
            choice = in.next();
        } 
        
        if (choice.equals("y")) {
            System.out.print("Enter an output file name: ");
            String outputFile = in.next();
            File output = new File(outputFile);
            PrintWriter out = new PrintWriter(output);
            out.println(statement);
            out.close();
            System.out.printf("Printed inside %s successfully!\n", 
                outputFile);
            System.out.println("End!");
            fileReader.close();
        } else if (choice.equals("n")) {
            System.out.println("End!");
            fileReader.close();     
        }
    } 
}

    