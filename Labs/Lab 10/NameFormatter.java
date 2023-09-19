//Max Dupler
//CSE 174 
//28 October 2021
//Lab10

import java.util.Scanner;

public class NameFormatter {

    //create method for printing options
    public static void options() {
        System.out.println("Select an Option!");
        System.out.println("1. Only First Name");
        System.out.println("2. First Name, and Last Name");
        System.out.println("3. First Name, Middle Initial, and Last Name");
        System.out.println("4. First Name, Middle Name, and Last Name");
        System.out.println("5. Exit");
    }
    
    //method to ask for the names
    public static void askForName() {
        System.out.print("Please enter the name parts separated by a space: ");
    }
    
    //main method
    public static void main(String[] args) {
        boolean keepGoing = true;
        System.out.println("Welcome to the Name Formatter");
        Scanner in = new Scanner(System.in);
        while (keepGoing) {
            options(); //print options
            int choice = in.nextInt();
            if (choice != 5) {
                askForName();
            }
            switch (choice) {
                case 1:
                    System.out.println(formatName(in.next()));
                    break;
                case 2: 
                    System.out.println(formatName(in.next(), in.next()));
                    break;
                case 3: 
                    System.out.println(formatName(in.next(), 
                        in.next().charAt(0), in.next()));
                    break;
                case 4: 
                    System.out.println(formatName(in.next(), in.next(), 
                        in.next()));
                    break;
                case 5:
                    System.out.println("Thank You for "
                        + "using the Name Formatter!");
                    keepGoing = false;
                    break;
                default:
                    break;
            }
        }     
    }
    
    /**.
     * formats the name when only first name is given
     * @param firstName a String 
     * @return name a String 
     */
    public static String formatName(String firstName) {
        return String.format("%-8s", firstName);
    }
    
    /**.
     * formats the name when first and last name are given
     * @param firstName a String
     * @param lastNme a String
     * @return name a String
     */
    public static String formatName(String firstName, String lastName) {
        return String.format("%-8s %-8s", firstName, lastName);
    }
    
    /**.
     * formats the name when first name, middle initial and last name are given
     * @param firstName a String
     * @param middleInitial a char
     * @param lastName a String
     * @return name a String
     */
    public static String formatName(String firstName, char middleInitial, 
        String lastName) {
        return String.format("%-8s %-8sS %-8s", firstName, middleInitial + ".",
            lastName);
    }
    
    /**. 
     * formats the name when a first name, middle name and last name are given
     * @param firstName a String
     * @param middleName a String
     * @param lastName a String
     * @return name a String
     */
    public static String formatName(String firstName, String middleName,
        String lastName) {
        return String.format("%-8s %-8s %-8s", firstName, middleName,
            lastName);
    }
}
  