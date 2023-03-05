package com.innowise.ball;

public abstract class Ball {

    private int weight;

    private int length;

    public Ball(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }


    public abstract String type();


    @Override
    public String toString() {
        return "Ball{" +
                "weight=" + weight +
                ", length=" + length +
                '}';
    }


    public int getWeight() {
        return weight;
    }


    public int getLength() {
        return length;
    }
}
