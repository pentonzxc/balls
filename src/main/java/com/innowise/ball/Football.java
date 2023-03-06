package com.innowise.ball;

public class Football extends Ball {

    public Football(int weight, int length) {
        super(weight, length);
    }


    @Override
    public String type() {
        return "Football";
    }


    @Override
    public String toString() {
        return type() + " " + super.toString();
    }

}
