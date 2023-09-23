package hw1_21000697_lethinhung.ex3;

public class ComplexNumber {

    private double real;

    private double imag;

    public ComplexNumber() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imag + "i";
    }

    public ComplexNumber add(ComplexNumber right) {
        double newReal = this.real + right.getReal();
        double newImag = this.imag + right.getImag();
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber multiply(ComplexNumber right) {
        double newReal = (this.real * right.getReal()) - (this.imag * right.getImag());
        double newImage = (this.real * right.getImag()) + this.imag * right.getReal();
        return new ComplexNumber(newReal, newImage);
    }

}
