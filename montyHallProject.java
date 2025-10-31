package MontyHallProject;

import java.util.Scanner;
import java.util.Random;

public class montyHallProject {

    public static void main(String[] args) {

        //Scanner for user input
        Scanner input = new Scanner(System.in);

        //Random for generating random numbers
        Random rand = new Random();

        //game title
        System.out.println("------Monty Hall Game------\n");

        //Calls the playRound method to play one round of the game
        playRound(input, rand);

        //Close the scanner
        input.close();
    }

    /**
     * This method randomly picks a prize door and then ask 
     * the user to pick a door. It then finds a empty door 
     * that the user hasn't picked and also one that isn't 
     * the prizeDoor. It then finds the remaining door and ask
     * the user if they would like to switch and then reveals 
     * the prize. It then checks if the user won or lost and 
     * prints out the result.
     * @param input
     * @param rand
     */
    public static void playRound(Scanner input, Random rand) {

        //Random prize door generator
        int prizeDoor = rand.nextInt(3) + 1;

        //Calls a method to ask the player to pick a door
        int userDoor = getUserDoor(input);

        //Calls a method to reveal an empty door
        int emptyDoor = getEmptyDoor(rand, prizeDoor, userDoor);
        System.out.println("The host opens door " + emptyDoor + " and it is empty.\n");

        //This line determines the remaining door
        int remainingDoor = 6 - (userDoor + emptyDoor);

        //Calls a method to ask player if they want to switch
        userDoor = askToSwitch(input, userDoor, remainingDoor);

        // Step 6: Reveal the prize
        System.out.println("The prize was behind door " + prizeDoor + ".");

        //Checks if the player won or lost
        if (userDoor == prizeDoor) {
            System.out.println("\n🎉 You won the prize!");
        } 
        else {
            System.out.println("\n😢 You lost. Better luck next time!");
        }
    }

    
    /**
     * This method asks the user to pick a door, checks if the input
     * is valid, and then prints the chosen door.
     * It does not use .equals() or switch.
     * @param input
     * @return the door number (1, 2, or 3)
     */
    public static int getUserDoor(Scanner input) {

        //Ask the user to pick a door
        System.out.print("Pick a door (one, two, or three): ");
        //Read input from user
        String userChoice = input.nextLine();

        //This converts the user's input to lower case
        userChoice = userChoice.toLowerCase();

        //This will store the user's chosen door number
        int userDoor = 0;

        //Checks if the user typed "one"
        if (userChoice.compareToIgnoreCase("one") == 0) {
            userDoor = 1;
        }

        //Checks if the user typed "two"
        if (userChoice.compareToIgnoreCase("two") == 0) {
            userDoor = 2;
        }

        //Checks if the user typed "three"
        if (userChoice.compareToIgnoreCase("three") == 0) {
            userDoor = 3;
        }

        //If none of the above were true, input is invalid
        if (userDoor == 0) {
            System.out.println("Invalid input! You must type one, two, or three.");
            //Ends the code
            System.exit(0);
        }

        //Tell the user which door they picked
        System.out.println("\nYou chose door " + userDoor + ".");

        //Return the user's door choice
        return userDoor;
    }


    /**
     * This method finds the empty door that isn't the prize door
     * and returns the empty door that the user hasn't picked.
     * @param rand
     * @param prizeDoor
     * @param userDoor
     * @return
     */
    public static int getEmptyDoor(Random rand, int prizeDoor, int userDoor) {

        int emptyDoor = rand.nextInt(3) + 1; //Random door 1-3

        //Makes sure it is not the prize or user's door
        if (emptyDoor == prizeDoor || emptyDoor == userDoor) {
        	//Pick the remaining door
            emptyDoor = 6 - (prizeDoor + userDoor);
        }
        
        //Returns the empty door
        return emptyDoor; 
    }
    

    /**
     * This method ask the user if they what to switch doors
     * Then checks if the input is valid then It switches the
     * door if the user says yes then changes the door and 
     * returns the final door choice.
     * @param input
     * @param userDoor
     * @param remainingDoor
     * @return
     */
    public static int askToSwitch(Scanner input, int userDoor, int remainingDoor) {

        //Ask user if they want to switch
        System.out.print("Would you like to switch to door " + remainingDoor + "? (yes or no): ");
        //Read input
        String switchAnswer = input.nextLine().toLowerCase();

        //Check if input is valid
        if (!switchAnswer.equals("yes") && !switchAnswer.equals("no")) {
            System.out.println("Invalid input! You must type yes or no.");
            //End program if invalid
            System.exit(0);
        }

        //Switch doors if user says yes
        if (switchAnswer.equals("yes")) {
        	//Change user door
            userDoor = remainingDoor;
            //Prints out new choice
            System.out.println("\nYou switched to door " + userDoor + ".");
        } 
        else {
        	//Print if stayed
            System.out.println("\nYou stayed with door " + userDoor + ".");
        }
        
        //Return the final door choice
        return userDoor;
    }
}
