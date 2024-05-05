
// Evan Knudsen

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private int numSides;
    private int value;

    public Die(int numSides, int value) {
        this.numSides = 6;
        this.value = 1;
    }

    public int getNumSides() {
        return this.numSides;
    }

    public int getValue() {
        return this.value;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Die(int numSides) {
        this.numSides = numSides;
        this.value = 1;
    }

    @Override
    public String toString() {
        return numSides + " sided die rolled a " + value;
    }

    public void roll() {
        this.value = ThreadLocalRandom.current().nextInt(1, numSides + 1);
    }
}
