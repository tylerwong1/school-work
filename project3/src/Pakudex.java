public class Pakudex {

    private final int capacity;
    private int size;
    private boolean check;
    private int counter = 0;
    private String species;
    private final Pakuri[] add;

    // default constructor
    public Pakudex() {
        capacity = 20;
        add = new Pakuri[capacity];
    }
    // constructor with a parameter
    public Pakudex(int capacity) {
        this.capacity = capacity;
        add = new Pakuri[this.capacity];
    }
    // returns size of the the pakudex
    public int getSize() {
        return counter;
    }
    // return max capacity of the pakudex
    public int getCapacity() {
        return capacity;
    }
    // get species by creating new string array and filling it with pakuri names
    public String[] getSpeciesArray() {
        String[] speciesArray = new String[counter];
        boolean check = true;
        // add names from add to String array
        for (int i = 0; i < counter; i++) {
            speciesArray[i] = add[i].getSpecies();
            check = false;
        }
        // return null array if speciesArray is empty
        if (check) {
            speciesArray = null;
        }
        return speciesArray;
    }
    // get stats method by creating an int array
    public int[] getStats(String species) {
        int[] stats = new int[3];
        boolean check = true;
        // add the stats values to the int array
        for (int i = 0; i < counter; i++) {
            if (add[i].getSpecies().equals(species)) {
                stats[0] = add[i].getAttack();
                stats[1] = add[i].getDefense();
                stats[2] = add[i].getSpeed();
                check = false;
            }
        }
        // return null array if stats is empty
        if (check)
            stats = null;
        return stats;
    }
    // sort pakuri method
    public void sortPakuri() {
        // sorting algorithm used to compare the values of species and determine the order
        for (int i = 0; i < counter; i++) {
            for (int j = i + 1; j < counter; j++) {
                if (add[i].getSpecies().compareTo(add[j].getSpecies()) > 0) {
                    // temp variable used as a place holder
                    Pakuri temp = add[i];
                    add[i]= add[j];
                    add[j] = temp;
                }
            }
        }
    }
    // add pakuri method
    public boolean addPakuri(String species) {
        // check if the array has reached max capacity
        if (counter <= capacity) {
            // check for duplication
            for (int i = 0; i < counter; i++) {
                if (add[i].getSpecies().equals(species)) {
                    return false;
                }
            }
            // creates new Pakuri object within the add array
            add[counter] = new Pakuri(species);
            counter++;
            check = true;
        } else {
            check = false;
        }
        return check;
    }
    // evolve species method
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < counter; i++) {
            if (add[i].getSpecies().equals(species)) {
                add[i].evolve();
                check = true;
                break;
            } else {
                check = false;
            }
        }
        return check;
    }
}


