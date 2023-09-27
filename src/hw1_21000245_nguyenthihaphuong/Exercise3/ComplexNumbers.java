package hw1_21000245_nguyenthihaphuong.Exercise3;

public class ComplexNumbers {
    private final double real;
    private final double imaginary;

    public ComplexNumbers(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumbers add(ComplexNumbers other) {
        return new ComplexNumbers(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumbers multiply(ComplexNumbers other) {
        double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new ComplexNumbers(newReal, newImaginary);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}
