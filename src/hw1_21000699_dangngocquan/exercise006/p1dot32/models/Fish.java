package hw1_21000699_dangngocquan.exercise006.p1dot32.models;

import hw1_21000699_dangngocquan.exercise006.p1dot32.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot32.models.Animal;

import javax.swing.*;

public class Fish extends Animal {
    private ImageIcon image;

    public Fish(Integer location, int gender, double strength) {
        super(location, gender, strength);
        this.image = gender == 0? Config.FISH_IMAGE_0 : Config.FISH_IMAGE_1;
    }

    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    @Override
    public int compareTo(Animal o) {
        return Double.compare(this.getStrength(), o.getStrength());
    }
}
