//Max Dupler
//CSE 174 
//Section C
//1 October 2021
//Lab4

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab6 {
    public static void main(String[] args) throws FileNotFoundException {
        
        //ask user for a file to read from
        System.out.print("Enter a file name: ");
        Scanner in = new Scanner(System.in);
        String inputFile = in.next();
        
        //ask for output file
        System.out.print("Enter an output file name: ");
        String outputFile = in.next();
        
        //make the file scanner
        File input = new File(inputFile);
        Scanner fileReader = new Scanner(input);
        
        //make print writer
        PrintWriter out = new PrintWriter(new File(outputFile));
        
        //initialize variables
        int grade = 0;
        String name = "";
        int scoreTotal = 0;
        int totalStudents = 0;
        char letter;
        //start loop that goes until all names and scores are read
        while (fileReader.hasNext()) {
            //use if to determine if the next statement is a int or string
            if (fileReader.hasNextInt()) {
                grade = fileReader.nextInt();
                scoreTotal += grade;
                //use if statement to store score as letter 
                //and print to output file
                if (grade >= 90) {
                    letter = 'A';
                } else if (grade >= 80) {
                    letter = 'B';
                } else if (grade >= 70) {
                    letter = 'C';
                } else if (grade >= 60) {
                    letter = 'D';
                } else {
                    letter = 'F';
                }
                out.println(letter); 
            } else {  
                name = fileReader.next();
                totalStudents++;
            }
        }
        double average = (double) scoreTotal / totalStudents;
        
        //print the output
        System.out.println("Number of students: " + totalStudents);
        System.out.printf("Class Average: %.2f", average);
        
        out.println("Number of students: " + totalStudents);
        out.printf("Class average: %.2f", average);
        
        out.close();  
        fileReader.close();
    }
}
            
                
                
        
        

