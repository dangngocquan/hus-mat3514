package hw1_21000506_nguyenthithanhhuong.ex3;

import java.util.List;

public class Complex {
    private double real, imag;

    public Complex() {
        real = 0;
        imag = 0;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    // Add two complexes method
    public Complex sumTwoComplex(Complex other) {
        Complex result = new Complex();
        result.real = this.real + other.real;
        result.imag = this.imag + other.imag;
        return result;
    }

    // Multiply two complexes method
    public Complex productTwoComplex(Complex other) {
        Complex result = new Complex();
        result.real = (this.real*other.real) - (this.imag*other.imag);
        result.imag = (this.real*other.imag) + (this.imag*other.real);
        return result;
    }

    // Add more complexes method
    public static Complex sumComplexes(List<Complex> list) {
        Complex sumComplexes = new Complex();
        if (list == null || list.isEmpty()) return null;
        for (Complex element : list) {
            sumComplexes = sumComplexes.sumTwoComplex(element);
        }

        return sumComplexes;
    }

    // Multiply more complexes method
    public static Complex productComplexes(List<Complex> list) {
        Complex productComplexes = new Complex(1, 1);
        if (list == null || list.isEmpty()) return null;
        for (Complex element : list) {
            productComplexes = productComplexes.productTwoComplex(element);
        }

        return productComplexes;
    }

    @Override
    public String toString() {
        String result = this.real + " + " + this.imag + "i";
        if (Double.compare(real, 0) == 0) {
            result = this.imag + "i";
        }
        if (Double.compare(imag, 0) == 0) {
            result = String.valueOf(this.real);
        }
        if (Double.compare(real, 0) == 0 && Double.compare(imag, 0) == 0) {
            result = "0";
        }
        if (Double.compare(imag, 0) < 0) {
            result = this.real + " - " + Math.abs(this.imag) + "i";
        }
        return result;
    }
}
