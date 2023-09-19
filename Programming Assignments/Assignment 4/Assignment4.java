//Max Dupler
//Assignment 4
//CSE 174
//6 December 2021

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Assignment4 {
    
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<Customer> customerList 
        = new ArrayList<Customer>();
    private static ArrayList<Customer> sortedList = new ArrayList<Customer>();
    private static boolean isLoaded = false;
    private static boolean isSorted = false;


    //main method
    public static void main(String[] args) throws FileNotFoundException {
        int menuSelection = 0;
        while (menuSelection != 6) {
            printMenu();
            menuSelection = in.nextInt();
            switch (menuSelection) {
                case 1: 
                    loadData();
                    break;
                case 2:
                    printList(customerList);
                    break;
                case 3: 
                    sort1(sortedList);
                    break;
                case 4:
                    sort2(sortedList);
                    break;
                case 5:
                    if (!isLoaded) {
                        System.out.println("No data has been loaded yet!\n");
                    } else if (isLoaded && !isSorted) {
                        System.out.println("Nothing is sorted yet!\n");
                    } else {
                        printList(sortedList);
                    }
                    break;
                case 6:
                    System.out.println("End!");
                    break;
                default:
                    break;
            }
        }
    }
    
    /**.
     * Prints the menu to prompt the user
     */
    public static void printMenu() {
        System.out.println("1. Load from a file");
        System.out.println("2. Print the loaded list");
        System.out.println("3. Sort the list based on the nicknames");
        System.out.println("4. sort the list based on the ids");
        System.out.println("5. Print the sorted list");
        System.out.println("6. Exit");
        System.out.print("Enter a number [1-6]: ");
    }
    
    /**.
     * prints the Customer list
     * @param cos a Customer object ArrayList
     */
    public static void printList(ArrayList<Customer> cos) {
        if (isLoaded) {
            System.out.println();
            boolean keepGoing = true;
            int index = 0;
            boolean printContinue = true;
            System.out.println("**** Printing the list ****");
            while (keepGoing) {
                for (int i = index; i < index + 10 && i < cos.size(); i++) {
                    System.out.println((i + 1) + ". " + cos.get(i));
                    if (i == cos.size() - 1) {
                        printContinue = false;
                        keepGoing = false;
                        System.out.println();
                    }
                }
                if (printContinue) {
                    System.out.print("Enter something " 
                        + "to continue/enter s to stop: ");
                    String selection = in.next();
                    if (selection.equals("s")) {
                        keepGoing = false;
                        System.out.println();
                    } else {
                        keepGoing = true;
                        index += 10;
                    }
                }
            }
        } else {
            System.out.println("No data has been loaded yet!");
            System.out.println();
        }
    }
    
    /**.
     * fills the array by scanning the file inputted by the user
     */
    public static void loadData() throws FileNotFoundException {
        removeAll(customerList);
        removeAll(sortedList);
        isLoaded = true;
        isSorted = false;
        System.out.print("\nEnter the name of the file: ");
        String fileName = in.next();
        File lst = new File(fileName);
        
        //fill array
        Scanner fileReader = new Scanner(lst);
        while (fileReader.hasNext()) {
            String name = fileReader.next();
            long id = fileReader.nextLong();
            Customer nextCos = new Customer(name, id);
            customerList.add(nextCos);
        }
        sortedList = clone(customerList, sortedList);
        System.out.println("Loading from the file is done!\n");
    }  
    
    /**.
     * sorts the customer list by nickname
     * @param cos a Customer object ArrayList
     */
    public static void sort1(ArrayList<Customer> cos) {
        if (!isLoaded) {
            System.out.println("No data has been loaded yet!\n");
        } else {
            boolean swap;
            isSorted = true;
            do {
                swap = false;
                for (int i = 0; i < cos.size() - 1; i++) {
                    String name = cos.get(i).getName();
                    String nextName = cos.get(i + 1).getName();
                    if (name.compareTo(nextName) > 0) {
                        Customer temp = cos.get(i);
                        cos.set(i, cos.get(i + 1));
                        cos.set((i + 1), temp);
                        swap = true;
                    }
                }
            } while (swap);
            System.out.println("Sorting is done!\n");
        }
    }
    
    /**.
     * sorts the customers by id number
     * @param cos a Customer object ArrayList
     */
    public static void sort2(ArrayList<Customer> cos) {
        if (!isLoaded) {
            System.out.println("No data has been loaded yet!\n");
        } else {
            boolean swap;
            isSorted = true;
            do {
                swap = false;
                for (int i = 0; i < cos.size() - 1; i++) {
                    long id = cos.get(i).getId();
                    long nextId = cos.get(i + 1).getId();
                    if (id > nextId) {
                        Customer temp = cos.get(i);
                        cos.set(i, cos.get(i + 1));
                        cos.set((i + 1), temp);
                        swap = true;
                    }
                }
            } while (swap);
            System.out.println("Sorting is done!\n");
        }
    }   
    
    /**.
     * clone an ArrayList by creating a deep copy
     * @param original an ArrayList that will be copied
     * @param copy an ArrayList that will be filled identical to the original
     * @return copy the copied ArrayList
     */
    public static ArrayList<Customer> clone(ArrayList<Customer> original, 
        ArrayList<Customer> copy) {
        copy.clear();
        for (int i = 0; i < original.size(); i++) {
            Customer c = original.get(i);
            copy.add(c);
        }
        return copy;
    }
    
    /**.
     * removes all elements from the ArrayList
     * @param cos a Customer ArrayList
     */
    public static void removeAll(ArrayList<Customer> cos) {
        int length = cos.size() - 1;
        for (int i = length; i >= 0; i--) {
            cos.remove(i);
        }
    }          
}  

