package hw3_20001970_duongtuanson.Bai1;

public class Fraction {
    private float numerator;
    private float denominator;
    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction add(Fraction c){
        float tu = this.numerator * c.denominator + this.denominator * c.numerator;
        float mau = this.denominator * c.denominator;
        Fraction result = new Fraction(tu, mau);
        return result;
    }
    public Fraction minus(Fraction c){
        float tu = this.numerator * c.denominator - this.denominator * c.numerator;
        float mau = this.denominator * c.denominator;
        Fraction result = new Fraction(tu, mau);
        return result;
    }
    public Fraction multiply(Fraction c){
        float tu = this.numerator * c.numerator;
        float mau = this.denominator * c.denominator;
        Fraction result = new Fraction(tu, mau);
        return result;
    }
    public Fraction divide(Fraction c){
        float tu = this.numerator * c.denominator;
        float mau = this.denominator * c.numerator;
        Fraction result = new Fraction(tu, mau);
        return result;
    }
    public Fraction normalize(Fraction c){
        float tu = this.numerator;
        float mau = this.denominator;
        if (tu == 0) {
            mau = 1;
        } else {
            if (tu < 0 && mau < 0) {
                tu = -tu;
                mau = -mau;
            } else if (mau < 0) {
                tu = -tu;
                mau = -mau;
            }
            for (int i = 2; i <= Math.min(tu, mau); i++) {
                if (tu % i == 0 && mau % i == 0) {
                    tu /= i;
                    mau /= i;
                    i--;
                }
            }
        }
        if(mau == 1){
            numerator = tu;
        }
        return new Fraction(tu, mau);
    }
    public float getNumerator() {
        return numerator;
    }
    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
       Fraction c = normalize(Fraction.this);
         return String.valueOf((int) c.numerator) + "/" + String.valueOf((int) c.denominator);
    }
}

