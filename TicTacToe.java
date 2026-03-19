import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        //creates scanner for user input
        Scanner input = new Scanner(System.in);

        //creates the tic tac toe board using a 2D array
        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        //stores the current player (starts with X)
        char currentPlayer = 'X';
        
        //boolean to track if the game is over
        boolean gameOver = false;
        
        //keeps track of how many moves have been made
        int moves = 0;

        System.out.println("Welcome to Tic Tac Toe!");

        //while loop that keeps the game running until gameOver becomes true
        while (!gameOver) {

            //prints the current board
            printBoard(board);

            //calls method to let player pick a spot
            pickSpot(currentPlayer, board, input);
            
            //adds 1 to moves after each turn
            moves++;

            //checks if the current player has won
            if (checkWinner(board, currentPlayer)) {

                //prints final board
                printBoard(board);
                
                //prints winner
                System.out.println("Player " + currentPlayer + " wins!");
                
                //ends the game
                gameOver = true;
            }

            //checks if all 9 moves have been made (tie)
            else if (moves == 9) {

                //prints final board
                printBoard(board);
                
                //prints tie message
                System.out.println("The game is a tie!");
                
                //ends the game
                gameOver = true;
            }

            //if no winner or tie, switch players
            else {

                //if current player is X, switch to O
                if (currentPlayer == 'X') {
                    currentPlayer = 'O';
                }
                //otherwise switch back to X
                else {
                    currentPlayer = 'X';
                }
            }
        }

        //closes scanner
        input.close();
    }

    //method to print the board
    public static void printBoard(char[][] board) {

        System.out.println("\nCurrent Board:");

        //for loop to go through each row
        for (int i = 0; i < board.length; i++) {

            //for loop to go through each column
            for (int j = 0; j < board[i].length; j++) {

                //prints each value with a space
                System.out.print(board[i][j] + " ");
            }

            //moves to next line after each row
            System.out.println();
        }

        System.out.println();
    }

    //method that lets player pick a spot on the board
    public static void pickSpot(char currentPlayer, char[][] board, Scanner input) {

        //asks user for row
        System.out.println("Player " + currentPlayer + ", enter row (0-2): ");
        int row = input.nextInt();

        //asks user for column
        System.out.println("Player " + currentPlayer + ", enter column (0-2): ");
        int col = input.nextInt();

        //checks if the spot is empty
        if (board[row][col] == '-') {

            //sets the spot to the current player
            board[row][col] = currentPlayer;
        }
        else {

            //tells user the spot is taken
            System.out.println("That space is already taken. Try again.");
            
            //calls the method again to retry
            pickSpot(currentPlayer, board, input);
        }
    }

    //method to check if a player has won
    public static boolean checkWinner(char[][] board, char player) {

        //for loop to check each row (horizontal win)
        for (int i = 0; i < 3; i++) {

            //checks if all 3 spots in the row are the same player
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {

                //returns true if there is a win
                return true;
            }
        }

        //for loop to check each column (vertical win)
        for (int j = 0; j < 3; j++) {

            //checks if all 3 spots in the column are the same player
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {

                //returns true if there is a win
                return true;
            }
        }

        //checks diagonal from top left to bottom right
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {

            return true;
        }

        //checks diagonal from top right to bottom left
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {

            return true;
        }

        //returns false if no win is found
        return false;
    }
}
