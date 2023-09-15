package hw1_21000699_dangngocquan.exercise006.p1dot32.models;

import hw1_21000699_dangngocquan.exercise006.p1dot32.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot32.models.Animal;

import javax.swing.*;

public class Bear extends Animal {
    private ImageIcon image;

    public Bear(Integer location, int gender, double strength) {
        super(location, gender, strength);
        this.image = gender == 0? Config.BEAR_IMAGE_0 : Config.BEAR_IMAGE_1;
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
