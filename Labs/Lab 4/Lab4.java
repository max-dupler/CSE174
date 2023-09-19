
/**
 * Max Dupler
 * CSE 174, all sections
 * Lab4.java
 * Sep, 2021
 * practicing printf method, Scanner and PrintWriter classes.
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Lab4 {
    // main method
    public static void main(String[] args) 
        throws FileNotFoundException {
        // Defining an Scanner object 
        Scanner in = new Scanner(System.in);
        
        // Prompting the user and getting a full name
        System.out.printf("Enter your first and last name: ");
        String name = in.next() + " " + in.next();
        
        // Prompting the user and getting sleep hours
        System.out.printf("Enter your time spent sleeping each night"
            + " (in hours): ");
        double sleepHours = in.nextDouble();
        
        // Prompting the user and getting number of classes
        System.out.printf("Enter your number of classes: ");
        int classes = in.nextInt();
        
        // Calculating free time
        double freeTime = 120 - (sleepHours * 5 + classes * 8.72);
        
        // Printing the results on the display
        System.out.printf(" ____________________________________________\n");
        System.out.printf("|%-20s|%-12s|%-10s|\n", "Name", "Num Classes", 
            "Free Time");
        System.out.printf("|............................................|\n");
        System.out.printf("|%-20s|%-12d|%-10.1f|\n", name, classes, freeTime);
        System.out.printf(" --------------------------------------------\n");
        
        // --------- Reading from a file ----------
        // Getting an input file name
        System.out.printf("Enter an input filename: ");
        String fileName = in.next();
        
        // Defining a Scanner object
        Scanner inF = new Scanner(new File(fileName));
        
        // Reading from the given file 
        String name2 = inF.next() + " " + inF.next();
        double sleepHours2 = inF.nextDouble();
        int classes2 = inF.nextInt();
        
        // Calculating BMI
        double freeTime2 = 120 - (sleepHours2 * 5 + classes2 * 8.72);
        
        // closing the inF object
        inF.close();
        
        // Printing the results on the display
        System.out.printf(" ____________________________________________\n");
        System.out.printf("|%-20s|%-12s|%-10s|\n", "Name", "Num Classes", 
            "Free Time");
        System.out.printf("|............................................|\n");
        System.out.printf("|%-20s|%-12d|%-10.1f|\n", name2, classes2, 
            freeTime2);
        System.out.printf(" --------------------------------------------\n");
        
        // --------- Writing in a file ----------
        // Getting an output file name
        System.out.printf("Enter an output filename: ");
        fileName = in.next();
        
        // Defining a PrintWriter object
        PrintWriter out = new PrintWriter(new File(fileName));
        
        // Writing inside the given text file
        out.printf(" ____________________________________________\n");
        out.printf("|%-20s|%-12s|%-10s|\n", "Name", "Num Classes", "Free Time");
        out.printf("|............................................|\n");
        out.printf("|%-20s|%-12d|%-10.1f|\n", name, classes, freeTime);
        out.printf("|............................................|\n");
        out.printf("|%-20s|%-12d|%-10.1f|\n", name2, classes2, freeTime2);
        out.printf(" --------------------------------------------\n");
        
        // closing the out object
        out.close(); 
    }
}

