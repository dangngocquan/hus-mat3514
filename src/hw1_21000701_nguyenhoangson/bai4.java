package hw1_21000701_nguyenhoangson;

import java.lang.Math;

class Sphere {
	private double radius;
	private double x;
	private double y;
	private double z;

	public Sphere(double radius, double x, double y, double z) {
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getSurfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	public double getVolume() {
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}

	public boolean isOverlapping(Sphere other) {
		double distance = Math
				.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
		return distance <= this.radius + other.radius;
	}

	public boolean isIntersecting(Sphere other) {
		double distance = Math
				.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2));
		return distance < this.radius + other.radius;
	}
}

public class bai4 {

	public static void main(String[] args) {
		Sphere sphere1 = new Sphere(6.0, 0.0, 0.0, 0.0);
		Sphere sphere2 = new Sphere(7.0, 8.0, 0.0, 0.0);

		System.out.println("Diện tích xung quanh hình cầu 1: " + sphere1.getSurfaceArea());
		System.out.println("Thể tích của hình cầu 1: " + sphere1.getVolume());

		System.out.println("Diện tích xung quanh hình cầu 2: " + sphere2.getSurfaceArea());
		System.out.println("Thể tích của hình cầu 2: " + sphere2.getVolume());

		if (sphere1.isOverlapping(sphere2)) {
			System.out.println("Hình cầu 1 và hình cầu 2 đang chồng lên nhau.");
		} else {
			System.out.println("Hình cầu 1 và hình cầu 2 không chồng lên nhau.");
		}

		if (sphere1.isIntersecting(sphere2)) {
			System.out.println("Hình cầu 1 và hình cầu 2 giao nhau.");
		} else {
			System.out.println("Hình cầu 1 và hình cầu 2 không giao nhau.");
		}
	}
}
