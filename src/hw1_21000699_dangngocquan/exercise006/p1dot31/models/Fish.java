package hw1_21000699_dangngocquan.exercise006.p1dot31.models;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import javax.swing.*;

public class Fish extends Animal {
    private ImageIcon image;

    public Fish(Integer location) {
        super(location);
        this.image = Config.FISH_IMAGE;
    }

    @Override
    public ImageIcon getImage() {
        return this.image;
    }
}
