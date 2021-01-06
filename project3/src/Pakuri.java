public class Pakuri {

    private final String species;
    private int attack;
    private int defense;
    private int speed;

    // constructor
    public Pakuri(String species) {
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }


    public String getSpecies() {
        return species;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setAttack(int newAttack) {
        attack = newAttack;
    }

    public void evolve() {
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }


}
