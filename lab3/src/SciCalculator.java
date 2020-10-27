/**
 * Tyler Wong
 * COP3502
 * Lab 3
 *
 * The purpose of this lab is to create a scientific calculator
 * that will allow the user to input two operands and perform a calculation.
 */
import java.util.Scanner;
public class SciCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double cResult = 0, average = 0, finalResult = 0;
        double firstOp, secondOp;
        int menu = 0, totalCalc = 0;

        //The entire program is put into a do-while loop because
        //it has to iterate multiple times until the user chooses to option to exit
        do {
            //The if-else statements are used to display the menu when menu is between 1 and 6.
            if (menu < 7 && menu > -1) {
                System.out.println("Current Result: " + cResult);
                System.out.println("\nCalculator Menu");
                System.out.println("---------------");
                System.out.println("0. Exit Program");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exponentiation");
                System.out.println("6. Logarithm");
                System.out.println("7. Display Average");
            }
            System.out.print("\nEnter Menu Selection: ");
            menu = scn.nextInt();
            //Input validation in case user gives a value for menu that is not valid
            while (menu == 7 && cResult == 0) {
                System.out.println("\nError: No calculations yet to average!");
                System.out.print("\nEnter Menu Selection: ");
                menu = scn.nextInt();
            }
            firstOp = 0;
            secondOp = 0;
            //Use of switch statements for menu-driven interface
            switch (menu) {
                case 0:
                    System.out.println("\nThanks for using this calculator. Goodbye!");
                    break;
                case 1:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    cResult = firstOp + secondOp;
                    //Add total for finalResult, which is used in later calculations
                    finalResult += cResult;
                    //Increment total amount of calculations after each iteration
                    totalCalc++;
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    //cResult is used to calculate the equation for the specific case
                    cResult = firstOp - secondOp;
                    finalResult += cResult;
                    totalCalc++;
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    cResult = firstOp * secondOp;
                    finalResult += cResult;
                    totalCalc++;
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    cResult = firstOp / secondOp;
                    finalResult += cResult;
                    totalCalc++;
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    cResult = Math.pow(firstOp, secondOp);
                    finalResult += cResult;
                    totalCalc++;
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter first operand: ");
                    firstOp = scn.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOp = scn.nextDouble();
                    //The formula below is necessary to calculate the log given the inputs
                    cResult = Math.log(secondOp) / Math.log(firstOp);
                    finalResult += cResult;
                    totalCalc++;
                    System.out.println();
                    break;
                case 7:
                    System.out.println("\nSum of calculations: " + finalResult);
                    System.out.println("Number of calculations: " + totalCalc);
                    //Double divided by an integer returns a double
                    average = finalResult/totalCalc;
                    System.out.print("Average of calculations: ");
                    //'printf' is used to format the amount of decimals that are outputted
                    System.out.printf("%.2f", average);
                    System.out.println();
                    break;
                default:
                    //This case is activated when the user picks an invalid number for menu
                    System.out.println("\nError: Invalid selection!");
                    break;
            }
            //Loop ends when menu = 0, because 0 is the exit menu
        } while (menu != 0);
    }
}
