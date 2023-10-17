package hw3_20001970_duongtuanson.Bai1;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap day n phan so: ");
        int n = sc.nextInt();
        Fraction[] a = new Fraction[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = new Fraction(rd.nextInt(10) + 1, rd.nextInt(10) + 1);
            System.out.println(a[i].getNumerator() + "/" + a[i].getDenominator());
        }
        System.out.print("Nhap vi tri: ");
        int v = sc.nextInt();
        System.out.println("vi tri " + v + " la: " + a[v-1].getNumerator() + "/" + a[v-1].getDenominator());

        Fraction sum = new Fraction(0, 1);
        for (int i = 0; i < n; i++) {
            sum = sum.add(a[i]);
        }
        System.out.println("Tong cac phan so: " + sum.normalize(sum));

        Fraction sub = new Fraction(0, 1);
        for (int i = 0; i < n; i++) {
            sub = sub.minus(a[i]);
        }
        System.out.println("Hieu cac phan so: " + sub.normalize(sub));

        Fraction mul = new Fraction(1, 1);
        for (int i = 0; i < n; i++) {
            mul = mul.multiply(a[i]);
        }
        System.out.println("Tich cac phan so: " + mul.normalize(mul));

        Fraction div = new Fraction(1, 1);
        for (int i = 0; i < n; i++) {
            div = div.divide(a[i]);
        }
        System.out.println("Thuong cac phan so: " + div.normalize(div));
    }

}
