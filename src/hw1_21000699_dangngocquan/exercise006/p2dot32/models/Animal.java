package hw1_21000699_dangngocquan.exercise006.p2dot32.models;

import javax.swing.*;

public abstract class Animal implements Comparable<Animal> {
    private Integer location;
    private int gender;
    private double strength;

    public Animal(Integer location, int gender, double strength) {
        this.location = location;
        this.gender = gender;
        this.strength = strength;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public abstract ImageIcon getImage();
}
