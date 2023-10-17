package hw3_22001273_nguyenhoangminh.excercise1;

import java.util.Arrays;
import java.util.Random;

public class FractionArray {
    Fraction[] fractionArray;
    int size;

    public FractionArray(int size) {
        this.size = size;
        Random rnd = new Random();
        fractionArray = new Fraction[size];

        for (int idx = 0; idx < size; ++idx) {
            fractionArray[idx] = new Fraction(rnd.nextFloat(-50,100), rnd.nextFloat(-50, 100));
        }
    }

    // Testing constructor
    public FractionArray() {
        Random rnd = new Random();
        fractionArray = new Fraction[3];

        for (int idx = 0; idx < 3; ++idx) {
            fractionArray[idx] = new Fraction(1.0f, 2.0f);
        }
        size = 3;
    }

    public String toString() {
        return Arrays.toString(fractionArray);
    }

    public Fraction getIndex(int n) {
        return fractionArray[n];
    }

    public Fraction sumArray() {
        Fraction sum = fractionArray[0];
        for (int i = 0; i < size - 1; ++i) {
            sum = sum.add(fractionArray[i+1]);
        }
        return sum.normalize();
    }

    public Fraction minusArray() {
        Fraction minus = fractionArray[0];
        for (int i = 0; i < size - 1; ++i) {
            minus = minus.minus(fractionArray[i+1]);
        }
        return minus.normalize();
    }

    public Fraction multiArray() {
        Fraction result = fractionArray[0];
        for (int i = 0; i < size - 1; ++i) {
            result = result.multi(fractionArray[i+1]);
        }
        return result.normalize();
    }

    public Fraction divideArray() {
        Fraction result = fractionArray[0];
        for (int i = 0; i < size - 1; ++i) {
            result = result.divide(fractionArray[i+1]);
        }
        return result.normalize();
    }

    public Fraction[] powerArray(int pow) {
        Fraction[] result = new Fraction[size];
        for (int i = 0; i < size; ++i) {
            result[i] = fractionArray[i].power(pow);
        }
        return result;
    }
}
