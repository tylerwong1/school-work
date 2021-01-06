import java.util.Scanner;
public class NumericConversion {
    public static long hexStringDecode(String hex) {
        double hexString = 0;
        int numOfInputs;
        double convert;

        // Determining the number of inputs is vital to decoding the string
        numOfInputs = hex.length();

        // Used to check if the user used a prefix when inputting the string
        if((hex.charAt(0) == '0' && (hex.charAt(1) == 'x') || (hex.charAt(1) == 'X'))) {
            // Using the method hexCharDecode to calculate each of the values of the characters of the String hex
            for (int i = 1; i <= (numOfInputs - 2); i++) {
                convert = hexCharDecode(hex.charAt(numOfInputs - i));
                // Multiplying the value by the power of 16 is used to determine the value at that position
                hexString += Math.pow(16, i-1) * convert;
            }

        } else {

            for (int i = 1; i <= numOfInputs; i++) {
                convert = hexCharDecode(hex.charAt(numOfInputs - i));
                hexString += Math.pow(16, i-1) * convert;
            }

        }

        return (long)hexString;
    }

    public static short hexCharDecode(char digit) {
        short value = 0;
        // Switch statements are used to determine the value of a given character
        switch (digit) {
            case '0':
                value = 0;
                break;
            case '1':
                value = 1;
                break;
            case '2':
                value = 2;
                break;
            case '3':
                value = 3;
                break;
            case '4':
                value = 4;
                break;
            case '5':
                value = 5;
                break;
            case '6':
                value = 6;
                break;
            case '7':
                value = 7;
                break;
            case '8':
                value = 8;
                break;
            case '9':
                value = 9;
                break;
            // Need to check for uppercase and lowercase letters and assign them to the proper values
            case 'A':
            case 'a':
                value = 10;
                break;
            case 'B':
            case 'b':
                value = 11;
                break;
            case 'C':
            case 'c':
                value = 12;
                break;
            case 'D':
            case 'd':
                value = 13;
                break;
            case 'E':
            case 'e':
                value = 14;
                break;
            case 'F':
            case 'f':
                value = 15;
                break;
        }
        return value;
    }

    public static short binaryStringDecode(String binary) {
        double convert = 0;
        double binaryString = 0;

        int length;
        length = binary.length();
        // if-else statement needed to check if user puts in the prefix for the string
        if((binary.charAt(0) == '0' && (binary.charAt(1) == 'b') || (binary.charAt(1) == 'B'))) {
            // Much like the other method, using a for-loop is necessary to determine the value of the string
            for (int i = 1; i <= (length - 2); i++) {
                convert = Character.getNumericValue(binary.charAt(length - i));
                binaryString += Math.pow(2, i-1) * convert;
            }
        } else {
            for (int i = 1; i <= length; i++) {
                convert = Character.getNumericValue(binary.charAt(length - i));
                binaryString += Math.pow(2, i-1) * convert;
            }
        }

        return (short)binaryString;
    }
    /*
    public static String binaryToHex(String binary) {

    }
    */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int choice = 0;
        String convert = "", result3;
        long result1;
        short result2;
        // while loop is used for a recurring loop that iterates infinitely times
        while (choice != 4) {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.print("\nPlease enter an option: ");
            choice = scn.nextInt();
            // make sure user is not prompted when picking the quit option
            if (choice != 4) {
                System.out.print("Please enter the numeric string to convert: ");
                convert = scn.next();
            }
            // menu interface is driven by switch statements
            switch (choice) {
                case 1:
                    result1 = hexStringDecode(convert);
                    System.out.println("Result: " + result1);
                    System.out.println();
                    break;
                case 2:
                    result2 = binaryStringDecode(convert);
                    System.out.println("Result: " + result2);
                    System.out.println();
                    break;
                case 3:
                    //result3 = binaryToHex(convert);
                    //System.out.println("Result: " + result3);
                    break;
                case 4:
                    System.out.println("Goodbye!");
            }

        }

    }
}
