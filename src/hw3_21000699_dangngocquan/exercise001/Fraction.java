package hw3_21000699_dangngocquan.exercise001;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        Fraction f1 = this.normalize();
        Fraction f2 = c.normalize();
        float numerator0 = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
        float denominator0 = f1.getDenominator() * f2.getDenominator();
        return (new Fraction(numerator0, denominator0)).normalize();
    }

    public Fraction minus(Fraction c) {
        Fraction f1 = this.normalize();
        Fraction f2 = c.normalize();
        float numerator0 = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
        float denominator0 = f1.getDenominator() * f2.getDenominator();
        return (new Fraction(numerator0, denominator0)).normalize();
    }

    public Fraction multi(Fraction c) {
        Fraction f1 = this.normalize();
        Fraction f2 = c.normalize();
        float numerator0 = f1.getNumerator() * f2.getNumerator();
        float denominator0 = f1.getDenominator() * f2.getDenominator();
        return (new Fraction(numerator0, denominator0)).normalize();
    }

    public Fraction div(Fraction c) {
        Fraction f1 = this.normalize();
        Fraction f2 = c.normalize();
        float numerator0 = f1.getNumerator() * f2.getDenominator();
        float denominator0 = f1.getDenominator() * f2.getNumerator();
        if (Float.compare(denominator0, 0) == 0) {
            System.out.println("Can't div ...");
            return null;
        }
        return (new Fraction(numerator0, denominator0)).normalize();
    }

    public Fraction normalize() {
        long numerator0 = (long) floatMultiPower10(numerator, 7);
        long denominator0 = (long) floatMultiPower10(denominator, 7);
        long gcd0 = gcd(Math.abs(numerator0), Math.abs(denominator0));
        numerator0 /= gcd0;
        denominator0 /= gcd0;
        return new Fraction(
                numerator0,
                denominator0
        );
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public float floatMultiPower10(float f, int power) {
        StringBuilder sb = new StringBuilder("");
        sb.append(f);
        int indexDot = sb.indexOf(".");
        if (indexDot > -1) {
            int numberDigitsAfterDot = sb.length() - indexDot - 1;
            if (numberDigitsAfterDot <= power) {
                sb.replace(indexDot, indexDot+1, "");
                power -= numberDigitsAfterDot;
            } else {
                while (power-- > 0) {
                    sb.replace(indexDot, indexDot+1, sb.charAt(indexDot+1) + "");
                    indexDot++;
                }
                sb.replace(indexDot, indexDot+1, ".");
            }
        }
        while (power-- > 0) {
            sb.append("0");
        }
        return Float.parseFloat(sb.toString());
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
        if (Float.compare(numerator, Math.round(numerator)) == 0 &&
            Float.compare(denominator, Math.round(denominator)) == 0) {
            int numerator0 = Math.round(numerator);
            int denominator0 = Math.round(denominator);
            if (denominator0 < 0) {
                numerator0 = -numerator0;
                denominator0 = -denominator0;
            }
            if (numerator0 < 0) {
                sb.append("(").append(numerator0).append(")");
            } else {
                sb.append(numerator0);
            }
            sb.append("/");
            if (denominator0 < 0) {
                sb.append("(").append(denominator0).append(")");
            } else {
                sb.append(denominator0);
            }
        } else {
            float numerator0 = numerator;
            float denominator0 = denominator;
            if (Float.compare(denominator0, 0) < 0) {
                numerator0 = -numerator0;
                denominator0 = -denominator0;
            }
            if (Float.compare(numerator0, 0) < 0) {
                sb.append("(").append(numerator0).append(")");
            } else {
                sb.append(numerator0);
            }
            sb.append("/");
            if (Float.compare(denominator0, 0) < 0) {
                sb.append("(").append(denominator0).append(")");
            } else {
                sb.append(denominator0);
            }
        }
        return sb.toString();
    }
}
