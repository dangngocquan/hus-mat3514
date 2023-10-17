package hw3_21000676_damhaidang.ex1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        return new Fraction(numerator * c.getDenominator() + c.getNumerator() * denominator,
                denominator * c.getDenominator());
    }

    public Fraction minus(Fraction c) {
        /* TODO */
        float num = numerator * c.getDenominator() - c.getNumerator() * denominator;
        float den = denominator * c.getDenominator();
        System.out.println(num);
        System.out.println(den);
        return new Fraction(num, den);
    }

    public Fraction multi(Fraction c) {
        return new Fraction(numerator * c.getNumerator(), denominator * c.getDenominator());
    }

    public Fraction divi(Fraction c) {
        return new Fraction(numerator * c.getDenominator(), denominator * c.getNumerator());
    }

    public Fraction normalized() {
        String num = String.valueOf(numerator);
        int len1 = num.substring(num.indexOf(".")).length() - 1;
        String denom = String.valueOf(denominator);
        int len2 = denom.substring(denom.indexOf(".")).length() - 1;

        numerator = Math.round(numerator * Math.pow(10, len1));
        denominator = Math.round(denominator * Math.pow(10, len2));
        if (denominator < 0) {
            denominator *= -1.0f;
            numerator *= -1.0f;
        }
        float gcd = findGCD(numerator, denominator);
        float numeratorAfter = numerator / gcd;
        float denominatorAfter = denominator / gcd;
        if (denominatorAfter < 0) {
            denominatorAfter *= -1;
            numeratorAfter *= -1;
        }
        return new Fraction(numeratorAfter, denominatorAfter);
    }


    private float findGCD(float a, float b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

        public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
