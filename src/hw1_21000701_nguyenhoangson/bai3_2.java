package hw1_21000701_nguyenhoangson;

class ComplexNumber {
	private double real;
	private double imaginary;

	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public ComplexNumber add(ComplexNumber other) {
		double newReal = this.real + other.real;
		double newImaginary = this.imaginary + other.imaginary;
		return new ComplexNumber(newReal, newImaginary);
	}

	public ComplexNumber multiply(ComplexNumber other) {
		double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
		double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
		return new ComplexNumber(newReal, newImaginary);
	}

	public String toString() {
		if (imaginary >= 0) {
			return real + " + " + imaginary + "i";
		} else {
			return real + " - " + (-imaginary) + "i";
		}
	}
}

public class bai3_2 {
	public static void main(String[] args) {
		ComplexNumber[] complexNumbers = new ComplexNumber[3];
		complexNumbers[0] = new ComplexNumber(2, 3);
		complexNumbers[1] = new ComplexNumber(1, -2);
		complexNumbers[2] = new ComplexNumber(-1, 1);

		ComplexNumber sum = complexNumbers[0];
		ComplexNumber product = complexNumbers[0];

		for (int i = 1; i < complexNumbers.length; i++) {
			sum = sum.add(complexNumbers[i]);
			product = product.multiply(complexNumbers[i]);
		}

		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
}
