/**
 * Tyler Wong
 * Project 2
 * COP3502
 */

import java.util.ArrayList;
import java.util.Scanner;
public class RleProgram {

    public static String toHexString(byte[] data) {
        StringBuilder result = new StringBuilder();
        int length = data.length;
        int check;
        // check values to convert into hexadecimal
        for(int i = 0; i < length; i++) {
            check = data[i];
            switch (check) {
                case 0:
                    // using a string builder to append easily
                    result.append('0');
                    break;
                case 1:
                    result.append('1');
                    break;
                case 2:
                    result.append('2');
                    break;
                case 3:
                    result.append('3');
                    break;
                case 4:
                    result.append('4');
                    break;
                case 5:
                    result.append('5');
                    break;
                case 6:
                    result.append('6');
                    break;
                case 7:
                    result.append('7');
                    break;
                case 8:
                    result.append('8');
                    break;
                case 9:
                    result.append('9');
                    break;
                case 10:
                    result.append('a');
                    break;
                case 11:
                    result.append('b');
                    break;
                case 12:
                    result.append('c');
                    break;
                case 13:
                    result.append('d');
                    break;
                case 14:
                    result.append('e');
                    break;
                case 15:
                    result.append('f');
                    break;
            }
        }
        // convert back to string before returning
        return result.toString();
    }

    public static int countRuns(byte[] flatData) {
        // has to start at 1 to automatically count the first run
        int result = 1;
        int length = flatData.length;
        int checkLimit = 0;
        // using for-loops to check the number of runs
        for (int i = 0; i < length - 1; i++) {
            if (flatData[i] != flatData[i + 1]) {
                result++;
            }
            if (flatData[i] == flatData[i + 1]) {
                checkLimit++;
                if (checkLimit > 15) {
                    checkLimit = 0;
                    result++;
                }
            }
        }
        // return the result
        return result;
    }

    public static byte[] encodeRle(byte[] flatData) {
        // need to determine the size of the array using a previous method
        int elements = countRuns(flatData) * 2;
        // create a new array for the encoded data
        byte[] result = new byte[elements];
        int length = flatData.length;
        byte counter = 1;
        int index = 0;

        for (int i = 0; i < length - 1; i++) {
            // checking if the values next to each other are the same
            if (flatData[i] == flatData[i + 1]) {
                counter++;
                if (counter >= 15) {
                    result[index] = counter;
                    result[index + 1] = flatData[i];
                    index += 2;
                    counter = 0;
                }
            }
            // checking if the values are different compared to the ones after it
            if (flatData[i] != flatData[i + 1]) {
                result[index] = counter;
                result[index + 1] = flatData[i];
                index += 2;
                counter = 1;
            }
            // check the end of the array
            if (i == length - 2) {
                result[index] = counter;
                result[index + 1] = flatData[i + 1];
            }
        }
        // return the result
        return result;
    }

    public static int getDecodedLength(byte[] rleData) {
        int result = 0;
        int elements = rleData.length;

        // for-loop runs though the entire array to check the length
        for (int i = 0; i < elements; i++) {
            if (i == 0 || i % 2 == 0)
            result += rleData[i];
        }

        return result;
    }

    public static byte[] decodeRle(byte[] rleData) {
        int index = rleData.length;
        int element = getDecodedLength(rleData);
        int iterations = 0;
        int update = 0;
        // size of the array is determined by a previous method
        byte[] result = new byte[element];
        int counter = 0;

        // nested for-loops are used to append the array
        for (int i = 0; i < index; i++)
            // if statement used to check the indexes of the array
            if ((i == 0) || (i % 2 == 0)) {
                iterations = rleData[i];
                for (counter = update; counter < iterations + update; counter++) {
                    result[counter] = rleData[i + 1];
                }
                update += iterations;
            }
        return result;
    }

    public static byte[] stringToData(String dataString) {
        int element = dataString.length();
        byte[] result = new byte[element];
        int convert = 0;

        // for-loop used to check the entirety of the string
        for (int i = 0; i < element; i++) {
            convert = dataString.charAt(i);
            // switch statements used to determine what to add to the resulting array
            switch (convert) {
                case '0':
                    result[i] = 0;
                    break;
                case '1':
                    result[i] = 1;
                    break;
                case '2':
                    result[i] = 2;
                    break;
                case '3':
                    result[i] = 3;
                    break;
                case '4':
                    result[i] = 4;
                    break;
                case '5':
                    result[i] = 5;
                    break;
                case '6':
                    result[i] = 6;
                    break;
                case '7':
                    result[i] = 7;
                    break;
                case '8':
                    result[i] = 8;
                    break;
                case '9':
                    result[i] = 9;
                    break;
                case 'a':
                    result[i] = 10;
                    break;
                case 'b':
                    result[i] = 11;
                    break;
                case 'c':
                    result[i] = 12;
                    break;
                case 'd':
                    result[i] = 13;
                    break;
                case 'e':
                    result[i] = 14;
                    break;
                case 'f':
                    result[i] = 15;
                    break;
            }
        }
        // return the resulting array
        return result;
    }


    public static String toRleString(byte[] rleData) {
        StringBuilder result = new StringBuilder();
        char check;
        int length = rleData.length;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            // convert hexadecimal to decimal values using switch statements
            if (i % 2 != 0) {
                switch (rleData[i]) {
                    case 0:
                        result.append('0');
                        break;
                    case 1:
                        result.append('1');
                        break;
                    case 2:
                        result.append('2');
                        break;
                    case 3:
                        result.append('3');
                        break;
                    case 4:
                        result.append('4');
                        break;
                    case 5:
                        result.append('5');
                        break;
                    case 6:
                        result.append('6');
                        break;
                    case 7:
                        result.append('7');
                        break;
                    case 8:
                        result.append('8');
                        break;
                    case 9:
                        result.append('9');
                        break;
                    case 10:
                        result.append('a');
                        break;
                    case 11:
                        result.append('b');
                        break;
                    case 12:
                        result.append('c');
                        break;
                    case 13:
                        result.append('d');
                        break;
                    case 14:
                        result.append('e');
                        break;
                    case 15:
                        result.append('f');
                        break;
                }
                counter++;
            }
            if (i % 2 == 0) {
                result.append(rleData[i]);
                counter++;
            }
            // determine where the : needs to be placed
            if (counter == 2 && i < length - 1) {
                counter = 0;
                result.append(':');
            }
        }
        // convert stringbuilder to string before returning the answer
        return result.toString();
    }

    public static byte[] stringToRle(String rleString) {
        int element = rleString.length();
        ArrayList<String> arr = new ArrayList<String>();
        String check = "";
        char check1;
        int sum = 0;
        int i = 0;

        while (i < element) {
            // conditional to check if the number of elements before the :
            if (rleString.charAt(i) != ':' && rleString.charAt(i+1) != ':' && rleString.charAt(i+2) != ':') {
                check = rleString.substring(sum, sum + 2);
                arr.add(check);
                sum += 2;
                check1 = rleString.charAt(sum);
                switch (check1) {
                    case '0':
                        arr.add("0");
                        break;
                    case '1':
                        arr.add("1");
                        break;
                    case '2':
                        arr.add("2");
                        break;
                    case '3':
                        arr.add("3");
                        break;
                    case '4':
                        arr.add("4");
                        break;
                    case '5':
                        arr.add("5");
                        break;
                    case '6':
                        arr.add("6");
                        break;
                    case '7':
                        arr.add("7");
                        break;
                    case '8':
                        arr.add("8");
                        break;
                    case '9':
                        arr.add("9");
                        break;
                    case 'a':
                    case 'A':
                        arr.add("10");
                        break;
                    case 'b':
                    case 'B':
                        arr.add("11");
                        break;
                    case 'c':
                    case 'C':
                        arr.add("12");
                        break;
                    case 'd':
                    case 'D':
                        arr.add("13");
                        break;
                    case 'e':
                    case 'E':
                        arr.add("14");
                        break;
                    case 'f':
                    case 'F':
                        arr.add("15");
                        break;
                }
                sum += 2;
                i += 4;
            }
            // conditional to check if the number of elements before the :
            if (rleString.charAt(i) != ':' && rleString.charAt(i+1) != ':' && rleString.charAt(i+2) == ':') {
                arr.add(rleString.substring(sum, sum + 1));
                sum++;
                check1 = rleString.charAt(sum);
                switch (check1) {
                    case '0':
                        arr.add("0");
                        break;
                    case '1':
                        arr.add("1");
                        break;
                    case '2':
                        arr.add("2");
                        break;
                    case '3':
                        arr.add("3");
                        break;
                    case '4':
                        arr.add("4");
                        break;
                    case '5':
                        arr.add("5");
                        break;
                    case '6':
                        arr.add("6");
                        break;
                    case '7':
                        arr.add("7");
                        break;
                    case '8':
                        arr.add("8");
                        break;
                    case '9':
                        arr.add("9");
                        break;
                    case 'a':
                    case 'A':
                        arr.add("10");
                        break;
                    case 'b':
                    case 'B':
                        arr.add("11");
                        break;
                    case 'c':
                    case 'C':
                        arr.add("12");
                        break;
                    case 'd':
                    case 'D':
                        arr.add("13");
                        break;
                    case 'e':
                    case 'E':
                        arr.add("14");
                        break;
                    case 'f':
                    case 'F':
                        arr.add("15");
                        break;
                }
                sum += 2;
                i += 3;
            }
            // checking the end elements
            if (i + 2 == rleString.length()) {
                arr.add(rleString.substring(sum, sum + 1));
                sum++;
                check1 = rleString.charAt(sum);
                switch (check1) {
                    case '0':
                        arr.add("0");
                        break;
                    case '1':
                        arr.add("1");
                        break;
                    case '2':
                        arr.add("2");
                        break;
                    case '3':
                        arr.add("3");
                        break;
                    case '4':
                        arr.add("4");
                        break;
                    case '5':
                        arr.add("5");
                        break;
                    case '6':
                        arr.add("6");
                        break;
                    case '7':
                        arr.add("7");
                        break;
                    case '8':
                        arr.add("8");
                        break;
                    case '9':
                        arr.add("9");
                        break;
                    case 'a':
                    case 'A':
                        arr.add("10");
                        break;
                    case 'b':
                    case 'B':
                        arr.add("11");
                        break;
                    case 'c':
                    case 'C':
                        arr.add("12");
                        break;
                    case 'd':
                    case 'D':
                        arr.add("13");
                        break;
                    case 'e':
                    case 'E':
                        arr.add("14");
                        break;
                    case 'f':
                    case 'F':
                        arr.add("15");
                        break;
                }
                sum++;
                i += 3;
            }
            // checking the end elements
            if (i + 3 == rleString.length()) {
                check = rleString.substring(sum, sum + 2);
                arr.add(check);
                sum += 2;
                check1 = rleString.charAt(sum);
                switch (check1) {
                    case '0':
                        arr.add("0");
                        break;
                    case '1':
                        arr.add("1");
                        break;
                    case '2':
                        arr.add("2");
                        break;
                    case '3':
                        arr.add("3");
                        break;
                    case '4':
                        arr.add("4");
                        break;
                    case '5':
                        arr.add("5");
                        break;
                    case '6':
                        arr.add("6");
                        break;
                    case '7':
                        arr.add("7");
                        break;
                    case '8':
                        arr.add("8");
                        break;
                    case '9':
                        arr.add("9");
                        break;
                    case 'a':
                    case 'A':
                        arr.add("10");
                        break;
                    case 'b':
                    case 'B':
                        arr.add("11");
                        break;
                    case 'c':
                    case 'C':
                        arr.add("12");
                        break;
                    case 'd':
                    case 'D':
                        arr.add("13");
                        break;
                    case 'e':
                    case 'E':
                        arr.add("14");
                        break;
                    case 'f':
                    case 'F':
                        arr.add("15");
                        break;
                }
                sum += 2;
                i += 4;
            }
        }

        // converts arraylist into desired array before returning
        byte[] result = new byte[arr.size()];
        for (int z = 0; z < arr.size(); z++) {
            result[z] = Byte.parseByte(arr.get(z));

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String fileName;
        int menu;
        String rleString = "";
        String hexString = "";

        // 1. Display welcome message
        System.out.println("Welcome to the RLE image encoder!");

        // 2. Display color test with the message
        System.out.println("\nDisplaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);
        System.out.println();
        System.out.println();

        byte[] imageData = null;

        // 3. Display the menu - Part A: do-while loop
        do {
            System.out.println("RLE Menu");
            System.out.println("--------");
            System.out.println("0. Exit");
            System.out.println("1. Load File");
            System.out.println("2. Load Test Image");
            System.out.println("3. Read RLE String");
            System.out.println("4. Read RLE Hex String");
            System.out.println("5. Read Data Hex String");
            System.out.println("6. Display Image");
            System.out.println("7. Display RLE String");
            System.out.println("8. Display Hex RLE Data");
            System.out.println("9. Display Hex Flat Data");
            System.out.print("\nSelect a Menu Option: ");
            menu = scn.nextInt();

            
            // use switch statements for menu
            switch (menu) {
                // 3.1 - option 1
                // ConsoleGfx.loadFile(userInput) and you want to store the returned byte[] into imageData array
                case 0:
                    System.exit(0);
                case 1:
                    System.out.print("Enter name of file to load: ");
                    fileName = scn.next();
                    imageData = ConsoleGfx.loadFile(fileName);
                    System.out.println();
                    break;
                // 3.2 - option 2
                // store ConsoleGfx.testImage into the imageData array
                case 2:
                    imageData = ConsoleGfx.testImage;
                    System.out.println("Test image data loaded.");
                    System.out.println();
                    break;
                    // decoding rle string
                case 3:
                    System.out.print("Enter an RLE string to be decoded: ");
                    rleString = scn.next();
                    stringToRle(rleString);
                    System.out.println();
                    break;
                    // 'stringtodata' method to be used
                case 4:
                    System.out.print("Enter the hex string holding RLE data: ");
                    hexString = scn.next();
                    stringToData(hexString);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter the hex string holding flat data: ");
                    hexString = scn.next();
                    stringToData(hexString);
                    System.out.println();
                    break;
                // 3.6 - option 6
                // display image stored inside of imageData array
                case 6:
                    System.out.println("Displaying image...");
                    ConsoleGfx.displayImage(imageData);
                    break;
                case 7:
                    System.out.print("RLE representation: " + toRleString(imageData));
                    System.out.println();
                    break;
                case 8:
                    System.out.print("RLE hex values: " + toHexString(imageData));
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Flat hex values: " + toHexString(decodeRle(imageData)));
                    System.out.println();
                    break;
            }

        } while (menu != 0);
    }
}
