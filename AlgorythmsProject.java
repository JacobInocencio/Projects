package Project2;

public class ArrayMethods {

    public static void main(String[] args) {

    	//Basic 1d array
        int[] numbers = {4, 5, 5, 2, 1, 6, 6, 6};

        //this is where I call my methods to test if they work.
        
        System.out.println("Smallest: " + smallest(numbers));
        System.out.println("");
        
        System.out.println("Smallest Index: " + smallestIndex(numbers));
        System.out.println("");
        
        System.out.println("Average: " + average(numbers));
        System.out.println("");
        
        System.out.println("Evens: " + allEven(numbers));
        System.out.println("");

        changeFives(numbers);
        System.out.print("After (5 to 0): ");
        printArray(numbers);
        System.out.println("");

        System.out.println("3InRow: " + threeInRow(numbers));
        System.out.println("");

        System.out.println("5 Shows: " + countNumber(numbers, 5));
        System.out.println("");

        reverse(numbers);
        System.out.print("Reversed: ");
        printArray(numbers);
        System.out.println("");

        shiftRight(numbers);
        System.out.print("Shifted: ");
        printArray(numbers);
        System.out.println("");

        selectionSort(numbers);
        System.out.print("Sorted: ");
        printArray(numbers);
        System.out.println("");
    }

    //print arrays
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //1. Return the smallest number in the array. 
    public static int smallest(int[] arr) {
    	
    	//Variable to hold the smallest number
        int min = arr[0];
        
        //For loop to go through the array to find the smallest number
        for(int i = 1; i < arr.length; i++) {
        	//if statement that compares the current number to the current min
            if(arr[i] < min) {
            	//if it is smaller then is declares the min as that new number
                min = arr[i];
            }
        }
        //returns the min of the array
        return min;
    }

    //2. Return the index of the smallest number in the array. 
    public static int smallestIndex(int[] arr) {
    	
    	//Stores the smallest number
        int min = arr[0];
        //Stores the index of the smallest number.
        int index = 0;
        
        //for loop to traverse the array
        for(int i = 1; i < arr.length; i++) {
        	//checks if the number is smaller than the number stored in min.
            if(arr[i] < min) {
            	
            	//changes the number stored in min to the current number stored in arr[i].
                min = arr[i];
                //makes the index the index of the smallest number that is in the array.
                index = i;
            }
        }
        
        //returns the index to the main.
        return index;
    }

    //3. Return the average of all numbers in the array. 
    public static double average(int[] arr) {
    	
    	//stores the sum of all the numbers together.
        int sum = 0;
        
        //for loop to traverse the array.
        for(int i = 0; i < arr.length; i++) {
        	
        	//adds all the numbers to the sum.
            sum += arr[i];
            
        }
        
        //returns the average by dividing the sum by the length.
        return (double) sum / arr.length;
    }

    //4. Return true if all numbers in the array are even, and return false otherwise.
    public static boolean allEven(int[] arr) {
    	
    	//for loop to traverse array.
        for(int i = 0; i < arr.length; i++) {
        	
        	//if statement to check if the number is even
            if(arr[i] % 2 != 0) {
            	
            	//return statement to return if one number is odd.
                return false;
                
            }
        }
        
        //return statement to return if all numbers are even
        return true;
    }

    //5. If the array ever has two consecutive 5's, change them to 0's. (For example, passing {4, 5, 5, 2, 1} changes the array to {4, 0, 0, 2, 1} ).
    public static void changeFives(int[] arr) {
    	
    	//for loop to traverse array.
        for(int i = 0; i < arr.length - 1; i++) {
        	
        	//if statement to see if the number is 5.
            if(arr[i] == 5 && arr[i+1] == 5) {
            	
            	//changes the 5 to a 0
                arr[i] = 0;
                //changes the next 5 to 0
                arr[i+1] = 0;
                
            }
        }
    }

    //6. Return true if any number shows up three times in a row, and return false otherwise.
    public static boolean threeInRow(int[] arr) {
    	
    	//for loop to traverse array.
        for(int i = 0; i < arr.length - 2; i++) {
        	
        	//If statement to find out if there are three numbers in a row.
            if(arr[i] == arr[i+1] && arr[i] == arr[i+2]) {
            	
            	//Returns if there are three consecutive.
                return true;
            }
        }
        
        //returns false if there isn't.
        return false;
    }

    //7. Pass an array of ints and an int to be searched for. Return how many times that int shows up in the array. (For example, passing ( {4, 5, 5, 2, 1} , 5) returns 2 because 5 shows up twice)
    public static int countNumber(int[] arr, int num) {
    	
    	//variable to keep count of how many times a number shows.
        int count = 0;

      //for loop to traverse array.
        for(int i = 0; i < arr.length; i++) {
        	
        	//if statement to see if the current number is the same as the number given.
            if(arr[i] == num) {
            	
            	//Adds to count if it is the same.
                count++;
                
            }
        }

        //returns the final count.
        return count;
    }

    //8. Alter an array so that is the backwards version of the array initially passed (for example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 5, 5, 4})
    public static void reverse(int[] arr) {
    	
    	//for loop to traverse array.
        for(int i = 0; i < arr.length / 2; i++) {
        	
        	//stores the current number in a temp variable.
            int temp = arr[i];
            //replaces that variable with a new one from the end.
            arr[i] = arr[arr.length - 1 - i];
            //replaces the temp with the next number.
            arr[arr.length - 1 - i] = temp;
            
        }
    }

    //9. Shift all elements in an array to the right. (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 4, 5, 5, 2})
    public static void shiftRight(int[] arr) {
    	
    	//Stores the last number in the array.
        int last = arr[arr.length - 1];

        //for loop to traverse array.
        for(int i = arr.length - 1; i > 0; i--) {
        	
        	//Changes the number to the next one in the array.
            arr[i] = arr[i - 1];
        }

        //Sets the last number to the first number in the array.
        arr[0] = last;
    }

    //10. Use either selection sort or insertion sort to sort an array. (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 4, 5, 5})
    public static void selectionSort(int[] arr) {
    	
    	//for loop to go through each position in the array
        for(int i = 0; i < arr.length - 1; i++) {
        	
        	//assumes the current index is the smallest
            int minIndex = i;

            //inner loop to find the actual smallest value in the remaining array
            for(int j = i + 1; j < arr.length; j++) {
            	
            	//checks if the current number is smaller than the current minimum
                if(arr[j] < arr[minIndex]) {
                	
                	//updates the index of the smallest number
                    minIndex = j;
                }
            }

            //swaps the current number with the smallest number found
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
        }
    }
}
