//Max Dupler 
//CSE 174
//23 September 2021
//Lab 5 - discount calculator

import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
    
        //printing menu
        System.out.println("*Discount Calculator*");
        System.out.println("1. Calculating dog discount");
        System.out.println("2. Calculating cat discount");
        System.out.println("3. Calculating rodent discount");
        System.out.print("Enter a number [1, 2, 3]: ");
        
        //get input from user on pet type and total purchase amount
        Scanner in = new Scanner(System.in);
        int petType = in.nextInt();
        
        System.out.print("Enter total purchase: ");
        double total = in.nextDouble();
        
        double discount = 0;
        
        //calculate discount
        if (total > 100) {
            switch (petType) {
                case 1:
                    discount = 20;
                    break;
                case 2:
                    discount = 15;
                    break;
                case 3: 
                    discount = 12;
                    break;
                default:
            }
        } else {
            discount = 10;
        }
        
        //calculate amount saved as a double
        double amountSaved = total * discount / 100.0;
        
        //print the discount and amount saved
        switch (petType) {
            case 1:
                System.out.print("Dog discount ");
                break;
            case 2: 
                System.out.print("Cat discount ");
                break;
            case 3: 
                System.out.print("Rodent discount ");
                break;
            default:
        }
        
        
        System.out.printf("(%d%%): %1.2f\n", (int) discount, amountSaved);
        
        //calculate and print the payable price
        double endPrice = total - amountSaved;
        
        System.out.printf("Price Payable: %1.2f\n", endPrice);
        System.out.println("End");
    }                   
}
