package hw1_21000699_dangngocquan.exercise003;

public class ComplexNumber {
    private int real;
    private int image;

    public ComplexNumber(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ComplexNumber add(ComplexNumber another) {
        return new ComplexNumber(
                this.getReal() + another.getReal(),
                this.getImage() + another.getImage()
        );
    }

    public ComplexNumber multiply(ComplexNumber another) {
        int real = this.getReal() * another.getReal() - this.getImage() * another.getImage();
        int image = this.getReal() * another.getImage() + this.getImage() * another.getReal();
        return new ComplexNumber(real, image);
    }

    @Override
    public String toString() {
        if (image < 0) return String.format("%d-%di", this.real, -this.image);
        return String.format("%d+%di", this.real, this.image);
    }


    public static ComplexNumber addMoreComplexNumbers(ComplexNumber[] complexNumbers) {
        if (complexNumbers.length == 0) return null;
        ComplexNumber result = complexNumbers[0];
        for (int i = 1; i < complexNumbers.length; i++) {
            result = result.add(complexNumbers[i]);
        }
        return result;
    }


    public static ComplexNumber multiplyMoreComplexNumbers(ComplexNumber[] complexNumbers) {
        if (complexNumbers.length == 0) return null;
        ComplexNumber result = complexNumbers[0];
        for (int i = 1; i < complexNumbers.length; i++) {
            result = result.multiply(complexNumbers[i]);
        }
        return result;
    }


}
