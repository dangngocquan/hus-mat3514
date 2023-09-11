package hw1_21000699_dangngocquan.exercise003;

public class Main {
    public static void main(String[] args) {
        // Create and show complex numbers
        ComplexNumber complexNumber1 = new ComplexNumber(10, -4);
        ComplexNumber complexNumber2 = new ComplexNumber(18, 12);
        System.out.printf("Complex number 1: %s\n", complexNumber1);
        // Complex number 1: 10-4i
        System.out.printf("Complex number 2: %s\n", complexNumber2);
        // Complex number 2: 18+12i

        // ----------------------------------------------------------------------

        // Add two complex numbers
        System.out.printf("\ncomplexNumber1 + complexNumber2 = %s\n",
                complexNumber1.add(complexNumber2));
        // complexNumber1 + complexNumber2 = 28+8i

        // Multiply two complex numbers
        System.out.printf("complexNumber1 * complexNumber2 = %s\n",
                complexNumber1.multiply(complexNumber2));
        // complexNumber1 * complexNumber2 = 228+48i

        // ----------------------------------------------------------------------

        ComplexNumber[] complexNumbers = new ComplexNumber[] {
                new ComplexNumber(1, 2),
                new ComplexNumber(2, 3),
                new ComplexNumber(3, 4),
                new ComplexNumber(4, 5),
                new ComplexNumber(5, 6)
        };

        // Show all complex number in array
        System.out.printf("\ncomplexNumbers = [\n");
        for (int i = 0; i < complexNumbers.length; i++) {
            System.out.print("\t" + complexNumbers[i]);
            System.out.println(i == complexNumbers.length-1? "" : ",");
        }
        System.out.println("]");
        // complexNumbers = [
        //     1+2i,
        //     2+3i,
        //     3+4i,
        //     4+5i,
        //     5+6i
        // ]

        // Add more complex numbers
        System.out.printf("Add all complex numbers: %s\n",
                ComplexNumber.addMoreComplexNumbers(complexNumbers));
        // Add all complex numbers: 15+20i

        // Multiply more complex numbers
        System.out.printf("Multiply all complex numbers: %s\n",
                ComplexNumber.multiplyMoreComplexNumbers(complexNumbers));
        // Multiply all complex numbers: 155-2010i

    }
}
