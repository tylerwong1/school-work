public class Cowsay {

    private static void listCows(Cow[] cows) {
        // iterate through the cows array and print out the name of each cow
        for (int i = 0; i < cows.length; i++) {
            System.out.print(cows[i].getName() + " ");
        }
    }
    private static Cow findCow(String name, Cow[] cows) {
        Cow result = null;
        // use a for-loop to iterate through the cows array and check if the given name is equal
        for (int i = 0; i < cows.length; i++) {
            if (name.equals(cows[i].getName())) {
                result = cows[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Cow[] cows = HeiferGenerator.getCows();

        String normal = "heifer";
        boolean check = true;

        // list option
        if (args[0].equals("-l")) {
            // list all the cows by looping through cows array
            System.out.print("Cows available: ");
            // call listCows method
            listCows(cows);
            System.out.println();
        }
        else if (args[0].equals("-n")) {
            // local variable needed only in this case
            String name = args[1];

            // new object of type dragon and ice-dragon
            Cow fire = new Dragon(name, null);
            Cow ice = new IceDragon(name, null);

            for (int i = 0; i < cows.length; i++) {
                // check if given input is equal to array component
                if (name.equals(cows[i].getName())) {
                    // print out message
                    for (int j = 2; j < args.length; j++)
                        System.out.print(args[j] + " ");
                    System.out.println();
                    System.out.println(findCow(name, cows).getImage());
                    check = false;
                }

            }
            // if input is dragon
            if (name.equals("dragon")) {
                if (((Dragon) fire).canBreatheFire()) {
                    System.out.println("This dragon can breathe fire.");
                }
            }
            // if input is ice dragon
            if (name.equals("ice-dragon")) {
                if (!(((IceDragon) ice).canBreatheFire())) {
                    System.out.println("This dragon cannot breathe fire.");
                }
            }

            // check for non array entries
            if (check) {
                System.out.println("Could not find " + name + " cow!");
            }

        } else {
            // default image is printed with message
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i] + " ");
            }
            System.out.println();
            System.out.println(findCow(normal, cows).getImage());
        }
    }
}
