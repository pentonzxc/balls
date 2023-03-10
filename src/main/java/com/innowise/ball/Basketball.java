package com.innowise.ball;

public class Basketball extends Ball {

    public Basketball(Color color, int weight, int length) {
        super(color, weight, length);
    }

    @Override
    public String type() {
        return "Basketball";
    }


    @Override
    public String toString() {
        return type() + " " + super.toString();
    }
}
