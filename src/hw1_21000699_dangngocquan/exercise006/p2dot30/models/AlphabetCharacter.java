package hw1_21000699_dangngocquan.exercise006.p2dot30.models;

public class AlphabetCharacter implements Comparable<AlphabetCharacter> {
    private char character;
    private int count;
    private double frequency;

    public AlphabetCharacter(char character, int count, double frequency) {
        this.character = character;
        this.count = count;
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(AlphabetCharacter o) {
        if (count == o.getCount()) {
            return character - o.getCharacter();
        }
        return -this.count + o.getCount();
    }
}
