package hw3_21000506_nguyenthithanhhuong.ex01;

import java.util.List;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Add two fractions
    public Fraction add(Fraction other) {
        float resNumerator, resDenominator;

        other = normalize(other);

        resNumerator = this.numerator*other.denominator + other.numerator*this.denominator;
        resDenominator = this.denominator*other.denominator;

        return normalize(new Fraction(resNumerator, resDenominator));
    }

    // Minus two fractions
    public Fraction minus(Fraction other) {
        float resNumerator, resDenominator;

        other = normalize(other);

        resNumerator = this.numerator*other.denominator - other.numerator*this.denominator;
        resDenominator = this.denominator*other.denominator;

        return normalize(new Fraction(resNumerator, resDenominator));
    }

    // Multiply two fractions
    public Fraction multi(Fraction other) {
        float resNumerator, resDenominator;

        other = normalize(other);

        resNumerator = this.numerator*other.numerator;
        resDenominator = this.denominator*other.denominator;

        return normalize(new Fraction(resNumerator, resDenominator));
    }

    // Divide two fractions
    public Fraction divi(Fraction other) {
        float resNumerator, resDenominator;

        other = normalize(other);

        if (Float.compare(other.numerator, 0) == 0) {
            System.out.println("Can't divide");
            return null;
        } else {
            resNumerator = this.numerator*other.denominator;
            resDenominator = this.denominator*other.numerator;
            return normalize(new Fraction(resNumerator, resDenominator));
        }
    }

    // Normalize a fraction
    public static Fraction normalize(Fraction frac) {
        long resNumerator, resDenominator;
        resNumerator = deleteCommaInRealNum(frac.numerator);
        resDenominator = deleteCommaInRealNum(frac.denominator);

        long temp = gcd(resNumerator, resDenominator);

        resNumerator /= temp;
        resDenominator /= temp;

        return new Fraction(resNumerator, resDenominator);
    }

    public static long deleteCommaInRealNum(float num) {
        int temp = 0;
        if (Float.compare(num, 0) < 0) {
            temp = 1;
            num *= -1;
        }
        while (Float.compare((float) Math.floor(num), num) != 0) {
            num *= 10;
        }

        if (temp == 1) {
            num *= -1;
        }

        return (long) num;
    }

    // Find gcd of two number
    public static long gcd(long num1, long num2) {
        if (num2 == 0) return num1;
        return gcd(num2, num1%num2);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        if (Float.compare(this.numerator, 0) < 0) {
            sb.append("(").append(this.numerator).append(")");
        } else {
            sb.append(this.numerator);
        }

        sb.append("/");

        if (Float.compare(this.denominator, 0) < 0) {
            sb.append("(").append(this.denominator).append(")");
        } else {
            sb.append(this.denominator);
        }

        return sb.toString();
    }
}
