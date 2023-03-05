package com.innowise.ball;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Cart {

    private Collection<Ball> balls;

    private Sort<Ball> strategy = Sort.defaultBallSort();

    public Cart() {
        this.balls = new ArrayList<>();
    }


    public void sort(BoolComparator<Ball> newComparator) {
        strategy.setComparator(newComparator);
        this.sort();
    }


    public void sort() {
        Ball[] arr = balls.toArray(Ball[]::new);

        strategy.sort(arr);

        balls = new ArrayList<>(Arrays.stream(arr).toList());
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


    public void setSort(Sort<Ball> sort) {
        this.strategy = sort;
    }

    public Collection<Ball> getBalls() {
        return balls;
    }
}
