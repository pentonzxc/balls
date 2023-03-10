package com.innowise;

import com.innowise.algo.merge.ParallelMergeSort;
import com.innowise.ball.Ball;
import com.innowise.ball.Basketball;
import com.innowise.ball.Cart;
import com.innowise.ball.Color;

import java.util.List;

import static com.innowise.ball.Ball.ColorComparator;
import static com.innowise.ball.Color.*;

public class App {
    public static void main(String[] args) {
        Cart cart = new Cart();
        ColorComparator comparator = new ColorComparator(List.of(Color.GREEN, Color.RED));

        cart.setSort(new ParallelMergeSort<>(comparator));
        cart.addAll(balls());

        cart.sort();

        cart.getBalls().forEach(System.out::println);
    }

    private static List<Ball> balls() {
        return List.of(
                new Basketball(RED, 1, 0),
                new Basketball(RED, 3, 0),
                new Basketball(BLUE, 3, 3),
                new Basketball(GREEN, 0, 0),
                new Basketball(GREEN, 1, 1),
                new Basketball(RED, 0, 0),
                new Basketball(BLUE, 2, 5),
                new Basketball(GREEN, 2, 1),
                new Basketball(RED, 0, 0),
                new Basketball(GREEN, 3, 0),
                new Basketball(GREEN, 10, 0),
                new Basketball(BLUE, 5, 0),
                new Basketball(BLUE, 19, 1),
                new Basketball(GREEN, 9, 12),
                new Basketball(RED, 7, 4),
                new Basketball(BLUE, 2, 4)
        );
    }
}