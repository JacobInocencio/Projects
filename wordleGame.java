package Projects;

/**
 * For this project, you will be creating a basic version of the Wordle game. 
 * You will hardcode a solution and a user must be prompted and allowed to input
 * a guess. Feel free to use this snippet to get yourself started. The game will 
 * then compute what letters are guessed to be in correct positions, incorrect
 * positions, and not in the word at all. Use X to show a letter is not in the 
 * word, ? to show the letter is in the wrong spot, and use the letter if it was 
 * guessed correctly. Precondition: the word will always be 5 letter and there 
 * will be no repeating letters, so MOLDY would be allowed but MOLDIEST is too 
 * long and PUTTY has repetitions (if they make a guess that is too long, too 
 * short, or has repititions, inform the user the guess is invalid and to try again). 

Example (bold is user, nonbold is computer):

Please make a guess!

razed

XXXXX

balms

bX?mX

blind

bliXX

blimp

Good job! You got the word, it was blimp!
 */

//imports scanner
import java.util.Scanner;
		 
public class WordleGame {
	
	//Creates the scanner input reader
	static Scanner inputReader = new Scanner(System.in);
	
	public static void main(String[] args) {

		gameStart();
		//generate a random word, then it checks if it has the right letters and gives 5 tries.
				
		//closes the scanner at the end
		inputReader.close();	
				
	}
			
	/**
	 * This method starts the game by assigning the winning word to a variable.
	 */
	private static void gameStart() {
		
		//instantiates the string to a variable named theWord
		String theWord = "tower";
				
		//gives the variable to a method that checks the input from the player
		wordCheck(theWord);
	}
			
	/**
	 * This method checks if the word given from the player is the correct word by 
	 * going through each of the letters and sees if they are correct, close, or wrong.
	 */
	 public static String wordCheck(String str) {
		
		 //counter
		 int count = 1;
		 
		 //loop that runs 5 times.
		 while (count<6) {
			 
			 //prints a prompt that says what try they are on
			 System.out.println("Attempt " + count + "/5.");
			 //prints a prompt that prompts the player to input a 5 letter guess
			 System.out.println("guess the WORDLE:");
			 
			 //takes the users input and stores it in a string variable named userInput
			 String userInput = inputReader.nextLine();
 		
		 	 //if statement that returns invalid input if the userInput is longer than 5 characters
			 //else statement if it is 5 characters long, then proceeds to run the rest of code.
			 if (userInput.length() < 5 || userInput.length() > 5) {
				 	
				 //prints "Invalid Input"
				 	System.out.print("Invalid Input");
			 }	
			 
			 else {

				 //runs a loop to go through all 5 characters
				 for (int i = 0; i < str.length(); i++) {

					 //if statement runs if the character matches the same index string character
					 if(userInput.charAt(i) == str.charAt(i)) {
						 
						 //Character is green
						 System.out.println("Letter " + userInput.charAt(i) + " = green.");
					 }
					 
					 //if the letter is in the word but not in the right place it prints out yellow.
					 else if (str.indexOf(userInput.charAt(i))>-1) {
						 
						 //Character is yellow
						 System.out.println("Letter " + userInput.charAt(i) + " = yellow");  
					 }
					 
			         //if both the previous booleans are false then this runs meaning the letter is not in the word.  
					 else if (!(userInput.charAt(i) == str.charAt(i))) {
						 
						 //Character is red
						 System.out.println("Letter " + userInput.charAt(i) + " = red");    
					 }
		        
				 }
	       
			 }  
			 //Adds 1 to the counter after each loop
			 count++;
		}
		//return str
		return str;
		 	 
    }
	             
}
		
