//Max Dupler
//CSE 174 Section c
//August 26, 2021
//Practicing writing, saving and compiling code

import java.util.Scanner;  //neeeded for user input

public class FirstProgram {

   public static void main(String[] args) {
      //declare local variables
      String first, last;
      int correctNumber, guess, guessCount;
      int triangleSize;
      Scanner keyboardReader = new Scanner(System.in);
      
      //get users first and last name
      System.out.print("What is your first and last name? ");
      first = keyboardReader.next();
      last = keyboardReader.next();
      String fullname = first + " " + last;
      
      //Display border and greeting
      drawBorder(100);
      welcome(first + " " + last);
      drawBorder(100);
      
      //explain the rules
      gameRules(first);
      
      //Start the game with a random number
      correctNumber = (int)(1 + 100 * Math.random());
      guessCount = 0;
      
      //Get first guess
      guessCount++;
      System.out.print("Enter guess #" + guessCount + ": ");
      guess = keyboardReader.nextInt();
      
      //loop until guess is correct
      while (guess != correctNumber) {
         
         //higher or lower?
         if(guess < correctNumber) {
            System.out.println("guess higher");
         }
         
         else {
            System.out.println("guess lower");
         }
         
         //get next guess
         guessCount++;
         System.out.print("Enter guess #" + guessCount + ": ");
         guess = keyboardReader.nextInt();
         
      }//end loop
      
      //by this point, user has guessed correctly
      //number. print the results
      System.out.println("Congratulations " + first + ".");
      System.out.println("You got it in " + guessCount + " guesses.");
      
      if (guessCount <= 10) {
         System.out.println("You are an excellent guesser. :)");
      }
      
      else {
         System.out.println("Try harder next time. :(");
      }
      
      //Display some art
      System.out.println();
      System.out.println("And now, some stars to make you happy!");
      
      for (int length = 7; length >= 1; length--) {
         drawBorder(length);
      }
      
      System.out.println("Goodbye!");
      
   }//end main
         
   
   //prints a personalized welcome message
   public static void welcome(String name) {
      System.out.println("Welcome, " + name + ".");
      System.out.println("This is my first CSE 174 programming assignment.");
      System.out.println("Let's play \"Guess My Number\"");
   
   }// end welcome
   
   //explains rules of the game
   public static void gameRules(String name) {
      System.out.println("Are you ready to play a game, " + name + "?");
      System.out.println("I will try to think of a number between 1 and 100");
      System.out.println("Try to guess it in 10 or fewer tries");
   
   }//end gameRules
   
   public static void drawBorder(int length) {
      for (int i = 0; i < length; i++) {
        System.out.print("*");
      }
   System.out.println();//moves to next line
   
   }//end drawBorder

}//end class