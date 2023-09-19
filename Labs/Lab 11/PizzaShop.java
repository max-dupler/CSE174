//Max Dupler
//CSE 174 
//Lab 11
//4 November 2021

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PizzaShop { //uses pizza classe to create pizzas
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter order filename: ");
        String fileName = kb.next();
        pizzaOrder(fileName);

    }
    

    /**.
     *calculates the price of a pizza
     *@param p the pizza to find the cost of
     *@return cost the cost of the pizza
    */
    public static double pizzaCost(Pizza p) {
        double cost = 0;
                
        //determine the cost of the crust
        boolean stuffedCrust = p.getCrust().contains("stuffed");
        
        //determine cost of the size
        switch (p.getSize()) {
            case "small":
                cost += 4.00;
                cost += stuffedCrust ? 1 : 0;
                break;
            case "medium":
                cost += 5.50;
                cost += stuffedCrust ? 2 : 0;
                break;
            case "large":
                cost += 7.00;
                cost += stuffedCrust ? 3 : 0;
                break;
            default:
                break;
        }
            
        
        //determine toppings cost
        Scanner in = new Scanner(p.getToppings());
        
        //check for anchovies
        if (p.getToppings().contains("anchovies")) {
            cost += .5;
        }            
        
        //use array to check how many toppings there are
        if (p.getToppings().length() > 3) {
            String[] toppings = p.getToppings().split(" ");
            cost += toppings.length * .75;
        }
        
        //determine delivery cost
        boolean delivery = p.getDelivery();

        if (delivery && cost < 10) {
            cost += 2.00;
        }
        
        return cost;
    } 
    
    /**.
     *Takes a file with a pizza order and prints the order and price
     *@param a file name
    */
    public static void pizzaOrder(String fileName) {
        
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            
            //create pizza with size and crust ordered
            Pizza p = new Pizza(fileReader.next(), fileReader.next());
            
            //determines delivery or carryout
            boolean delivery = fileReader.next().contains("delivery");
            p.setDelivery(delivery);
            
            //print and set toppings ordered
            System.out.println("---Toppings---");
            while (fileReader.hasNext()) {
                String topping = fileReader.next();
                if (p.hasTopping(topping)) {
                    System.out.println(topping + ": DUPLICATE. NOT ADDED.");
                } else if (!p.addTopping(topping)) {
                    System.out.println(topping + ": TRY PAPA JOHNS.");
                } else {
                    System.out.println(topping + ": added");
                }
            }
            
            //print order and cost
            double cost = pizzaCost(p);
            System.out.println("---Here is your order---");
            System.out.println(p);
            System.out.printf("Your total is $" 
                + String.format("%.2f", cost) + ".\n");
            System.out.println("---Have a nice day---");
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println("INVALID ORDER. GOODBYE");
        }
    }            
}
