package hw1_21000699_dangngocquan.exercise006.p1dot31.models;

import javax.swing.*;

public abstract class Animal {
    private Integer location;

    public Animal(Integer location) {
        this.location = location;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public abstract ImageIcon getImage();
}
