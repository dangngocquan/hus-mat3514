package hw1_21000701_nguyenhoangson;

class Complex {
	private double real;
	private double imaginary;

	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public void printComplex() {
		if (imaginary < 0) {
			System.out.println(real + " - " + Math.abs(imaginary) + "i");
		} else {
			System.out.println(real + " + " + imaginary + "i");
		}
	}

	public Complex add(Complex other) {
		double resultReal = this.real + other.real;
		double resultImaginary = this.imaginary + other.imaginary;
		return new Complex(resultReal, resultImaginary);
	}

	public Complex multiply(Complex other) {
		double resultReal = this.real * other.real - this.imaginary * other.imaginary;
		double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
		return new Complex(resultReal, resultImaginary);
	}
}

public class bai3_1 {
	public static void main(String[] args) {
		Complex complex1 = new Complex(6, 7);
		Complex complex2 = new Complex(8, 9);

		System.out.println("Số phức 1:");
		complex1.printComplex();

		System.out.println("Số phức 2:");
		complex2.printComplex();

		// Cộng hai số phức
		Complex sum = complex1.add(complex2);
		System.out.println("Tổng của hai số phức:");
		sum.printComplex();

		// Nhân hai số phức
		Complex product = complex1.multiply(complex2);
		System.out.println("Tích của hai số phức:");
		product.printComplex();
	}
}
