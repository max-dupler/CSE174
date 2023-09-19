/**.
 * Max Dupler
 * CSE 174
 * November 18th 2021
 */
 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab13 {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //find and print number of lines in the file
        File customers = new File("customer_list.txt");
        Scanner fileReader = new Scanner(customers);
        int count = 0;
        while (fileReader.hasNext()) {
            fileReader.nextLine();
            count++;
        }
        System.out.println("There are " + count + " lines in the file"); 
        
        //make customer array
        Customer[] cos = new Customer[1004718];
        
        //reopen file
        fileReader = new Scanner(customers);
        
        //fill array using loop
        for (int i = 0; i < cos.length; i++) {
            String name = fileReader.next();
            long id = fileReader.nextLong();
            Customer nextCustomer = new Customer(name, id);
            cos[i] = nextCustomer;
        }
        //testing array
        System.out.println("[0]: " + cos[0]);
        System.out.println("[10]: " + cos[10]);
        System.out.println("[1000]: " + cos[1000]);
        System.out.println("[1000000]: " + cos[1000000]);
        System.out.println("[last index]: " + cos[cos.length - 1]);
        
        //testing search methods
        System.out.println("The object " + cos[0] 
            + " located at the index of: " + linearSearch(cos, cos[0]));
            
        System.out.println("The object " + cos[0] 
            + " located at the index of: " + binarySearch(cos, cos[0]));
        
        Customer a = new Customer("mqzhfygjuk", 6001073675L);
        Customer b = new Customer("gnv", 7412760286L);
        Customer c = new Customer("CSE174", 1111111111);
        
        System.out.println("The object " + a 
            + " located at the index of: " 
            + linearSearch(cos, a));
            
        System.out.println("The object " + a 
            + " located at the index of: " 
            + binarySearch(cos, a));
            
        System.out.println("The object " + b
            + " located at the index of: " 
            + linearSearch(cos, b));
            
        System.out.println("The object " + b 
            + " located at the index of: " 
            + binarySearch(cos, b));
            
        System.out.println("The object " + c 
            + " located at the index of: " 
            + linearSearch(cos, c));
            
        System.out.println("The object " + c
            + " located at the index of: " 
            + binarySearch(cos, c));
        
       
    }
    
    /**.
     * returns the index of a target Customer in a list of Customers
     * @param cos an array of Customer objects
     * @param key a Customer object being searched for
     * @returns the index of the key Customer
     */
    public static int linearSearch(Customer[] cos, Customer key) {
        int count = 0;
        for (int i = 0; i < cos.length; i++) {
            count++;
            if (cos[i].equals(key)) {
                System.out.println("Linear Search: The key is found after " 
                    + count + " comparison");  
                return i;
            }
        }
        System.out.println("Linear Search: The key is found after "
            + count + "comparison");
        return -1;
    }
    
    /**.
     * returns the index of a target Customer in a list of Customers
     * @param cos an array of Customer objects
     * @param key a Customer object being searched for
     * @returns the index of the key Customer
     */
    public static int binarySearch(Customer[] cos, Customer key) {
        int low = 0;
        int high = cos.length - 1;
        long target = key.getId();
        int count = 0;
        while (high >= low) {
            count++;
            int middle = (high + low) / 2;
            if (cos[middle].equals(key)) {
                System.out.println("Binary Search: the key is found after " 
                    + count + " comparison");
                return middle;
            } else if (cos[middle].getId() > target) {
                high = middle - 1;
            } else if (cos[middle].getId() < target) {
                low = middle + 1;
            }
        }
        System.out.println("Binary Search: the key is found after " 
            + count + " comparison");
        return -1;
    }                      
}
