package com.innowise.ball;

public abstract class Ball {

    private int weight;

    private int length;

    private Color color;

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
