import java.util.*;
public class ConnectFour {
    // method to print board
    public static void printBoard(char[][] array) {
        // nested for-loops to iterate through a 2D array
        for(int i = array.length - 1; i >= 0; i--) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    // initializing each component of the array to '-'
    public static void initializeBoard(char[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }
    }
    // inserting chip into board
   public static int insertChip(char[][] array, int col, char chipType) {
        int row = 0;
        // check to see if the chip is already placed in a spot
        for(int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                row = i;
                break;
            }
        }
        return row;
    }
    // checking if there is a winner
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        boolean checkIfWinner = false;
        int counterH = 0;
        int counterV = 0;
        int tie = 0;
        // array[0] is valid because every row has the same number of entries
        int area = array.length * array[0].length;

        //  check for  horizontal wins
        for (int i = 0; i < array[0].length; i++) {
            if (array[row][i] == chipType) {
                counterH++;
                if (counterH == 4)
                    checkIfWinner = true;
            } else
                // counter used to check if consecutive
                counterH = 0;
        }
        // check for vertical win
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                counterV++;
                if (counterV == 4)
                    checkIfWinner = true;
            } else
                // counter used to check if consecutive
                counterV = 0;
        }
    return checkIfWinner;
    }
    // main method
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int height, length, col1, col2, row1, row2;
        char chip1 = 'x';
        char chip2 = 'o';
        int counter = 0;

        System.out.print("What would you like the height of the board to be? ");
        height = scn.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        length = scn.nextInt();
        char[][] board = new char[height][length];

        // initialize board using the initialize array
        initializeBoard(board);
        // print board using the print method
        printBoard(board);
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        System.out.println();

        // while loop used to keep iterating until someone wins or ties
        while (true) {
           System.out.print("Player 1: Which column would you like to choose? ");
           col1 = scn.nextInt();
           row1 = insertChip(board, col1, chip1);
           // counter used to check for ties
           counter++;
           printBoard(board);
           if (checkIfWinner(board, col1, row1, chip1)) {
               System.out.println("Player 1 won the game!");
               // exit game once someone wins
               System.exit(0);
           }
           // check for ties
           if (counter == height * length) {
               System.out.println("Draw. Nobody wins.");
               System.exit(0);
           }

           // repeat of the code above for player 2
           System.out.print("Player 2: Which column would you like to choose? ");
           col2 = scn.nextInt();
           row2 = insertChip(board, col2, chip2);
           counter++;
           printBoard(board);
           if (checkIfWinner(board, col2, row2, chip2)) {
               System.out.println("Player 2 won the game!");
               System.exit(0);
           }
           // check for ties
           if (counter == height * length) {
               System.out.println("Draw. Nobody wins.");
               System.exit(0);
           }
       }
    }
}
