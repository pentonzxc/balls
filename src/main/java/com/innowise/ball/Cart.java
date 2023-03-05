package com.innowise.ball;

import java.util.ArrayList;
import java.util.Collection;

public class Cart {

    private Collection<Ball> balls;

    public Cart() {
        this.balls = new ArrayList<>();
    }

    public Cart(Collection<Ball> balls) {
        this.balls = balls;
    }


    public void add(Ball ball) {
        balls.add(ball);
    }


    public void addAll(Collection<Ball> balls) {
        this.balls.addAll(balls);
    }


    public void remove(Ball ball) {
        balls.remove(ball);
    }


    @Override
    public String toString() {
        return "Cart{" +
                "balls=" + balls +
                '}';
    }


    public Collection<Ball> getBalls() {
        return balls;
    }
}
