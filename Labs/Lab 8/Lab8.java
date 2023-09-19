//Max Dupler
//CSE 174 Section A
//15 October 2021
//Lab 8 part 2

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab8 {
    public static void main(String[] args) {
          
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        
        do {
            int inputNum = 0;
            boolean repeatInput = true;
            System.out.print("Enter an int number: ");
            
            //try reading next input as an int
            try {
                inputNum = in.nextInt();
                
                if (inputNum > 0) {
                    for (int numRow = 1; numRow < inputNum + 1; numRow++) {
                        for (int numColumn = 1; numColumn < inputNum 
                            + 1; numColumn++) {
                            String letter = (numRow % numColumn == 0)
                                ? "O" : "X";
                            System.out.print(letter);
                        }
                        System.out.println();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            //catch exceptions
            } catch (InputMismatchException error) {
                String invalidInput = in.next();
                repeatInput = false;
                System.out.println("Invalid Input!");
            } catch (IllegalArgumentException error) {
                System.out.println(
                    "No result with an input less than or equal to zero!");
                repeatInput = true;
            }
            
            while (repeatInput) {
                System.out.print("Do you want to repeat (y/n)? ");
                String userChoice = in.next();
                
                if (userChoice.equals("y") || userChoice.equals("Y")
                    || userChoice.equals("n") || userChoice.equals("N")) {
                    repeatInput = false;
                    repeat = userChoice.equals("y") || userChoice.equals("Y");
                }
            }
        } while (repeat);
        System.out.println("End");
    }
}
      