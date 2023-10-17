package hw3_22001273_nguyenhoangminh.excercise1;

public class Fraction {
    private float numerator, denominator;

    public Fraction(float numerator, float denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public float gcd(float numerator, float denominator) {
        if (denominator==0) { return numerator; }
        return gcd(denominator,numerator % denominator);
    }

    public Fraction normalize() {
        float GCD = gcd(this.numerator, this.denominator);
        float newNum = this.numerator / GCD;
        float newDem = this.denominator / GCD;
        if (newDem < 0 && newNum > 0) {
            newDem *= -1;
            newNum *= -1;
        }
        return new Fraction(newNum, newDem);
    }

    public Fraction add(Fraction c) {
        float resultNum, resultDem;
        if (this.denominator == c.denominator) {
            resultNum = this.numerator + c.numerator;
            return new Fraction(resultNum, this.denominator).normalize();
        } else {
            resultNum = this.numerator * c.denominator + this.denominator * c.numerator;
            resultDem = this.denominator * c.denominator;
            return new Fraction(resultNum, resultDem).normalize();
        }
    }

    public Fraction minus(Fraction c) {
        float resultNum, resultDem;
        if (this.denominator == c.denominator) {
            resultNum = this.numerator - c.numerator;
            return new Fraction(resultNum, this.denominator).normalize();
        } else {
            resultNum = this.numerator * c.denominator - this.denominator * c.numerator;
            resultDem = this.denominator * c.denominator;
            return new Fraction(resultNum, resultDem).normalize();
        }
    }

    public Fraction multi(Fraction c) {
        float resultNum, resultDem;
        resultNum = this.numerator * c.numerator;
        resultDem = this.denominator * c.denominator;
        return new Fraction(resultNum, resultDem).normalize();
    }

    public Fraction divide(Fraction c) {
        float resultNum, resultDem;
        if (c.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        resultNum = this.numerator * c.denominator;
        resultDem = this.denominator * c.numerator;

        return new Fraction(resultNum, resultDem).normalize();
    }

    // Viet them ham mu
    public Fraction power(int pow) {
        if (pow == 0) { return new Fraction(1.0f, 1.0f); }
        float resultNum = this.numerator;
        float resultDem = this.denominator;

        for (int i = 1; i < pow; ++i) {
            resultNum *= resultNum;
            resultDem *= resultDem;
        }
        return new Fraction(resultNum, resultDem).normalize();
    }

    public float getNumerator() { return numerator; }
    public float getDenominator() { return denominator; }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
