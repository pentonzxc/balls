package com.innowise.ball;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Cart implements Iterable<Ball> {

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


    public void addAll(Collection<? extends Ball> balls) {
        this.balls.addAll(balls);
    }


    public void remove(Ball ball) {
        balls.remove(ball);
    }


    public void setSort(Sort<Ball> sort) {
        this.strategy = sort;
    }


    public Sort<Ball> getStrategy() {
        return strategy;
    }


    public Collection<Ball> getBalls() {
        return balls;
    }


    @Override
    public Iterator<Ball> iterator() {
        return balls.iterator();
    }


    @Override
    public String toString() {
        return "Cart{" +
                "balls=" + balls +
                '}';
    }
}
