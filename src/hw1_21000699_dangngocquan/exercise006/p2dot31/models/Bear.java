package hw1_21000699_dangngocquan.exercise006.p2dot31.models;

import hw1_21000699_dangngocquan.exercise006.p2dot31.Config;

import javax.swing.*;

public class Bear extends Animal {
    private ImageIcon image;

    public Bear(Integer location) {
        super(location);
        this.image = Config.BEAR_IMAGE;
    }


    @Override
    public ImageIcon getImage() {
        return this.image;
    }
}
