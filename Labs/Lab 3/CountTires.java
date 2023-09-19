//Max Dupler
//CSE 174 Section C
//September 10th, 2021
//Tire Counting

public class CountTires {
    public static void main(String[] args) {
        //defining variables
        final int NUM_PAIRS = 19873123;
        int totalTires = NUM_PAIRS * 2;
        int carsProduced = totalTires / 4;
        int tiresRemaining = totalTires % 4;
        
        //printing output
        System.out.println("The number of: " + totalTires  
            + " tires are added to the production line!");
        System.out.println(carsProduced + " cars are produced.");
        System.out.println(tiresRemaining + " tires are left.");
    }
}

  