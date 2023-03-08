package com.innowise.ball;

public abstract class Ball {

    protected int weight;

    protected int length;

    protected Color color;

    public Ball(Color color, int weight, int length) {
        this.weight = weight;
        this.length = length;
        this.color = color;
    }


    public abstract String type();


    @Override
    public String toString() {
        return "Ball{" +
                "weight=" + weight +
                ", length=" + length +
                ", color=" + color +
                '}';
    }

    public int getWeight() {
        return weight;
    }


    public int getLength() {
        return length;
    }


    public Color getColor() {
        return color;
    }
}
