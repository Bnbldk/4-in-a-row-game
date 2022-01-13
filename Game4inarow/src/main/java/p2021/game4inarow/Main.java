package p2021.game4inarow;

import java.util.ArrayList;
//imports java utilities
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bruno Borges
 */

public class Main {

    //Static method to get the first name
    public static String name() {
        //Scanner method to prompt the user
        Scanner s = new Scanner(System.in);
        System.out.println("Please, type your full name: ");
        String name = s.nextLine();

        //split the First name
        String[] firstName = name.split(" ");

        //return just the first name
        return firstName[0];
    }

    //Static method to get the age between 12-100
    public static String age() {
        Scanner s = new Scanner(System.in);
        String age = null;
        
        //loop until get a valid age
        do {
            //user prompt
        System.out.println("type your age (over 12 and under 100): ");
        age = s.nextLine();

        //Checking if the age is between 12 - 100 (String to int to check)
        // else return invalid message
        if (Integer.valueOf(age) > 12 && (Integer.valueOf(age) < 100)) {
            return age;
        } else {
            System.out.println("Invalid age");
        }
        } while(true);
    }

    //Static method to get a valid email
    public static String email() {
        Scanner s = new Scanner(System.in);
        //loop until get a valid email address
        do {
        System.out.println("and now, a valid e-mail (must have '@' and '.'): ");
        String email = s.nextLine();
        
        //checking if the email contains @ and . to proceed
        if (email.contains("@") && email.contains(".")) {
            return email;
        } else {
            System.out.println("Invalid e-mail");
        }
        } while(true);
    }

    //exit method to quit the game
    public static void exit() {
        System.exit(0);
    }

    //Game set to choose the type of game and set the 5x5 or 10x10 game
    public static String gameSet(String number) {
        //scanner method for prompt user
        Scanner s = new Scanner(System.in);
        
        //loop for get the valid game type
        do {
            System.out.println("Type Number 1: short game. Number 2: long game. Number 3: Quit the game.");
            number = s.nextLine();
            
            //switch statement to get the valid number
            switch (number) {
                case "1" -> {
                    return "5";
                }
                case "2" -> {
                    return "10";
                }
                case "3" ->
                    exit();
                default ->
                    System.out.println("Invalid number");
            }
        } while (true); // while loop
    }

    //main method and body of the game
    public static void main(String[] args) {
        
        //Default game type
        String type = "5"; // default: short game 5x5      
        
        // Scanner method for prompt the user
        Scanner s = new Scanner(System.in);

        //Rules of the game              
        System.out.println("4 in a row Game \n"
                + "Choosing a column you must connect 4 spot in a row to win (vertical, horizontal or diagonal), \n"
                + "Let's get started");
        
        
        // Creating an object Player
        Player P = new Player(name(), age(), email());  
                
        //Creating a game grid object
        GameGrid game;
        
        //Creating a Score object
        Score score = new Score();
        
        //Game loop
        do {
            //printing the Player toString
            System.out.println(P);     
            //printing the Score toString
            System.out.println(score);
            
            //Game body: pick the columns
            do {
                //Prompt the user the type of game
                type = gameSet(type);
                //Creating a board game related to the game set
                game = new GameGrid(type);  
                
                //while loop to play the board until the end
                while (GameGrid.getInit() == true) {
                    // Pick column
                    System.out.println(P.getName() + ", pick a column ");
                    int columnPick = s.nextInt();

                    // Game play with a integer parameter related to the column
                    game.gamePlay(columnPick);
                }
            } while (GameGrid.getInit() == true); // While loop when finish the game back to the previous loop to choose the game type

        } while (true); // infinite loop that can be broken by user typing '3'
    }
} // end of main method
