/**
 * Max Dupler
 * Section: C
 * Sep 2021
 * Program1.java
 * This program decodes the digits.
 */
import java.util.Scanner;  // importing Scanner class

public class Program1 {
    public static void main(String[] args) {
        // Defining a Scanner object
        Scanner in = new Scanner(System.in);
        
        // Prompting the user with a message
        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");
        
        // Saving the given number inside a constant variable
        final long PHONE_NUM = in.nextLong();
        
        //separating digits
        int stationNum = (int) (PHONE_NUM % 10000);
        int officeCode = (int) (PHONE_NUM / 10000) % 1000;
        int areaCode = (int) (PHONE_NUM / 10000000);
        
        //print phone number
        System.out.println("(" + areaCode + ")" + " " 
            + officeCode + " - " +  stationNum);
        
        //encrypting station number
        int station1Digits = (stationNum % 100) + 33;
        int station2Digits = (stationNum / 100) + 33;
        
        //Converting last 4 digits to char
        char firstDigits = (char) station1Digits;
        char secondDigits = (char) station2Digits;
       
        //print phone number with char variables 
        System.out.println("(" + (int) areaCode + ")" + " " 
            + officeCode + " - " +  firstDigits + secondDigits);
        
        //combine remaining six digits
        int combo = (areaCode * 1000) + officeCode;
        
        //subtract phone number from max value
        int finalValue = Integer.MAX_VALUE - combo;
        System.out.println(finalValue);
        
        
        //print final number
        System.out.print(firstDigits);
        System.out.print(finalValue);
        System.out.print(secondDigits);
        
    }
}
