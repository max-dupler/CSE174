/**
 * Max Dupler
 * Lab9.java
 * Practicing writing methods.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab9 {
    // main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int option;
        
        do {
            menu();  // Displaying the menu
            try {
                option = in.nextInt();
            } catch (InputMismatchException err) {
                in.next();  // clearing the input
                option = 0; // picking zero as a value for the option
            }
            switch (option) {
                case 1:
                    System.out.printf("Enter a single binary code: ");
                    char letter = getLetter(in.next());
                    System.out.printf("The letter is: %s\n", letter);
                    break;
                case 2:
                    System.out.printf("Enter binary codes: ");
                    String word = getWord(in.next());
                    System.out.printf("The word is: %s\n", word);
                    break;
                case 3:
                    System.out.printf("End!\n");
                    break;
                default:
                    System.out.printf("Invalid Input!\n");
            }
        } while (option != 3);
    }
    
    /*
     * Prints a menu with options on the display.
     */
    private static void menu() {
        System.out.printf("\n**Binary Code Translator v 1.0**\n");
        System.out.printf("1. Translate a binary code into a letter\n");
        System.out.printf("2. Translate binary codes into a word\n");
        System.out.printf("3. Exit\nEnter a number [1-3]: ");
    }
    
    // TODO
    // ADD getLetter and getWord methods here 
    
    /*
    * This method returns a character when given an 8-digit binary code
    * @param binary a String value
    * @return binary code a char value
    */
    public static char getLetter(String binary) {
        int binaryCode = 0; //initialize ASCII code as an int
        int a = 7; //a represents the exponent
        for (int i = 0; i < binary.length(); i++) {
            //get numeric value of binary code by digit
            int binaryValue = Character.getNumericValue(binary.charAt(i));
            //convert to ASCII number and add to total
            binaryCode += (binaryValue * (Math.pow(2, a)));
            a--;
        }
        //return total number and convert to char
        return (char) binaryCode;
    }
    
    /*
    * This method returns a word when given a binary code
    * @param binary a String value
    * @return word a String value
    */
    public static String getWord(String binary) {
        //get number of 8 digit codes
        int numChar = binary.length() / 8;
        //initialize String to hold the word
        String word = "";
        for (int a = 0; a < numChar; a++) {
            int start = a * 8; //calculates where to start substring
            int end = (a + 1) * 8; //calculates where to end substiring
            //add each letter to the word
            word += getLetter(binary.substring(start, end));
        }
        return word;         
    }
            
}
