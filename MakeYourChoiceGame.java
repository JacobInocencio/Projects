

/**
 * You will be making a final project that is a Make Your Choice game. 
 * The user will be prompted to make choices that should change the 
 * final outcome of the game. It must meet the following requirements:

1. It must contain at least two classes: A Main class and something 
akin to a Character class. The main class will handle the logic, and 
the other class(es) will create objects with setters and getters to 
determine how your character(s) change as the game progresses. 

2. It should prompt the user for info that will become the attributes 
of a Character object. For example, the user should immediately be 
prompted about things like thier age, name, HP, etc. 

The character class should have attributes, a constructor that includes 
all attributes, and setters and getters. 

3. It must contain a path with at least 4 different decisions to make 
(not including deciding character attributes) and have at least 4 
unique endings. 

4. It must include a while loop in which the user is prompted for an 
input, but if they do not put a valid input then they are reprompted. 
If the input is valid, then the loop ends. 

5. It must include at least one for loop. Its placement is totally 
at your own discretion.
 */

//Imports java scanner
import java.util.Scanner;

public class MakeYourChoiceGame {

    //Creates the scanner input reader
    static Scanner inputReader = new Scanner(System.in);

    public static void main(String[] args) {

        //Starts the game
        gameStart();

        //Closes the scanner at the end
        inputReader.close();
    }

    /**
     * This method starts the game and creates the character.
     */
    private static void gameStart() {

        //Prompts the user for their name
        System.out.println("Enter your name:");

        //Stores the user's name
        String name = inputReader.nextLine();

        //Prompts the user for starting HP
        System.out.println("Enter your starting HP:");

        //Stores the HP
        int hp = inputReader.nextInt();

        //Prompts the user for courage level
        System.out.println("Enter your courage level (1-10):");

        //Stores the courage
        int courage = inputReader.nextInt();

        //Creates the character object
        Character player = new Character(name, hp, courage);

        //Starts the story
        firstChoice(player);
    }

    /**
     * This method contains the first choice in the game.
     */
    private static void firstChoice(Character player) {

        //Variable to store user choice
        int choice = 0;

        //Loop that repeats until valid input is entered
        while (choice != 1 && choice != 2) {

            //Prints out story text
            System.out.println("You are standing at the edge of a forest.(choose a number)");

            //Prints out choices
            System.out.println("1. Enter the forest");
            System.out.println("2. Walk away");

            //Stores the user's choice in choice variable
            choice = inputReader.nextInt();
        }

        //If the user enters the forest
        if (choice == 1) {

            //Decreases HP
            player.setHp(player.getHp() - 5);

            //Moves to second choice
            secondChoice(player);
        }

        //If the user walks away
        else {

            //Decreases courage
            player.setCourage(player.getCourage() - 1);

            //Moves to second choice
            secondChoice(player);
        }
    }

    /**
     * This method contains the second choice in the game.
     */
    private static void secondChoice(Character player) {

        //Prints story text
        System.out.println("You hear a strange sound nearby.(choose a  number)");

        //Prints choices
        System.out.println("1. Investigate the sound");
        System.out.println("2. Ignore it");

        //Stores the user's choice in choice variable
        int choice = inputReader.nextInt();

        //If the user investigates
        if (choice == 1) {

            //Increases courage
            player.setCourage(player.getCourage() + 1);
        }

        //If the user ignores the sound
        else {

            //Decreases HP
            player.setHp(player.getHp() - 3);
        }

        //Moves to travel section
        travel(player);
    }

    /**
     * This method uses a for loop to simulate travel.
     */
    private static void travel(Character player) {

        //Prints travel message
        System.out.println("You travel for 3 days.");

        //Loop that runs 3 times to print days passing
        for (int i = 1; i <= 3; i++) {

            //Prints current day
            System.out.println("Day " + i + " passes.");

            //Decreases HP each day
            player.setHp(player.getHp() - 1);
        }

        //Moves to final choice
        finalChoice(player);
    }

    /**
     * This method contains the final decision and endings.
     */
    private static void finalChoice(Character player) {

        //Prints final challenge
        System.out.println("A monster appears in front of you.(choose a number)");

        //Prints choices
        System.out.println("1. Fight the monster");
        System.out.println("2. Run away");

        //Stores the user's choice in choice variable
        int choice = inputReader.nextInt();

        //Ending 1 (checks hp and courage, at a certain level the ending plays.)
        if (choice == 1 && player.getHp() > 10 && player.getCourage() >= 5) {
            System.out.println("ENDING 1: You defeat the monster and become a hero.");
        }

        //Ending 2 (If hp is not high enough you die.)
        else if (choice == 1) {
            System.out.println("ENDING 2: You fight but are defeated.");
        }

        //Ending 3 (if courage is not a certain number you escape.)
        else if (choice == 2 && player.getCourage() >= 6) {
            System.out.println("ENDING 3: You escape safely.");
        }

        //Ending 4 (any other outcome you run away and lose.)
        else {
            System.out.println("ENDING 4: You run away and give up adventuring.");
        }
    }
}
