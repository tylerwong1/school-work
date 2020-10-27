/*
    Tyler Wong
    Calculator.java
    September 15, 2020
    COP350

    This program is designed to mimic a four function calculator
    by prompting the user to input two numbers and then offering four different operations.
 */
import java.util.Scanner;

public class Calculator {

    public static void main (String[] args) {
        //Declare scanner
        Scanner scn = new Scanner(System.in);

        //Declaration of variables
        double firstOp, secondOp;
        int choice;

        //Introduction nad prompting user for two numbers
        System.out.print("Enter first operand: ");
        firstOp = scn.nextDouble();
        System.out.print("Enter second operand: ");
        secondOp = scn.nextDouble();

        //Menu
        System.out.println("\nCalculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("\nWhich operation do you want to perform? ");
        choice = scn.nextInt();

        /*
        Using a switch statements to drive a menu interface makes the code much cleaner and simpler compared to using
        multiple if-else statements.
         */
        switch(choice) {
            case 1:
                System.out.print("The result of the operation is " + (firstOp + secondOp) + ". Goodbye!");
                break;
            case 2:
                System.out.print("The result of the operation is " + (firstOp - secondOp) + ". Goodbye!");
                break;
            case 3:
                System.out.print("The result of the operation is " + (firstOp * secondOp) + ". Goodbye!");
                break;
            case 4:
                System.out.print("The result of the operation is " + (firstOp / secondOp)+ ". Goodbye!");
                break;
            default:
                System.out.println("Error: Invalid selection! Terminating program.");
                break;

        }











    }
}
