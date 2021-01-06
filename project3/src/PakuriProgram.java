import java.util.*;
public class PakuriProgram {
    // method use to display the menu
    public static void displayMenu() {
        System.out.println();
        System.out.println("Pakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String menu = "0";
        String maxCap;
        int capacity = 0;
        String species;
        boolean test = false;

        // beginning menu
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        maxCap = scn.next();
        // test cases to catch errors from user input when entering max capacity
        while (!test) {
            try {
                Integer.parseInt(maxCap);
                // input validation for negative values
                if (Integer.parseInt(maxCap) < 1) {
                    throw new Exception();
                }
                test = true;
            } catch (Exception e) {
                test = false;
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                maxCap = scn.next();
            }
        }
        System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri.");
        // create a new pakudex object given the user capacity
        Pakudex paku = new Pakudex(Integer.parseInt(maxCap));

        while (Integer.parseInt(menu) != 6) {
            displayMenu();
            System.out.print("What would you like to do? ");
            menu = scn.next();
            // input validation for menu choice
            test = false;
            while (!test) {
                try {
                    Integer.parseInt(menu);
                    if (Integer.parseInt(menu) < 1 || Integer.parseInt(menu) > 6) {
                        throw new Exception();
                    }
                    test = true;
                } catch (Exception e) {
                    test = false;
                    System.out.println("Unrecognized menu selection!");
                    displayMenu();
                    System.out.print("What would you like to do? ");
                    menu = scn.next();
                }
            }
            // switch statements for the different options
            switch (Integer.parseInt(menu)) {
                case 1:
                    // check if pakudex is empty
                    if (paku.getSize() == 0) {
                        System.out.println("No Pakuri in Pakudex yet!");
                        break;
                    }
                    // list species in pakudex
                    System.out.println("Pakuri In Pakudex:");
                    for (int i = 0; i < paku.getSize(); i++) {
                        System.out.println((i + 1) + ". " + paku.getSpeciesArray()[i]);
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the species to display: ");
                    species = scn.next();
                    test = true;
                    // check to see if species input is within the pakudex
                    //if (Arrays.asList(paku.getSpeciesArray()).contains(species)) {
                    for (int i = 0; i < paku.getSize(); i++) {
                        if (paku.getSpeciesArray()[i].equals(species)) {
                            System.out.println();
                            System.out.println("Species: " + species);
                            // use getStats method to call the stats of the pakuri
                            System.out.println("Attack: " + paku.getStats(species)[0]);
                            System.out.println("Defense: " + paku.getStats(species)[1]);
                            System.out.println("Speed: " + paku.getStats(species)[2]);
                            test = false;
                        }
                    }
                    if (test) {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 3:
                    // checks to see if pakudex is full
                    if (capacity == Integer.parseInt(maxCap)) {
                        System.out.println("Error: Pakudex is full!");
                        break;
                    }
                    System.out.print("Enter the name of the species to add: ");
                    species = scn.next();
                    // will only execuse if pakuri is able to be added
                    if (paku.addPakuri(species)) {
                        System.out.println("Pakuri species " + species + " successfully added!");
                        capacity++;
                    } else {
                        // if test case fails, an error is thrown
                        System.out.println("Error: Pakudex already contains this species!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the species to evolve: ");
                    species = scn.next();
                    // checks to see if evolve will return positive
                    if (paku.evolveSpecies(species)) {
                        System.out.println(species + " has evolved!");
                    } else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;
                case 5:
                    System.out.println("Pakuri have been sorted!");
                    // sort method
                    paku.sortPakuri();
                    break;
                case 6:
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
            }

        }
    }
}


