package com.innowise;

import com.innowise.algo.merge.ParallelMergeSort;
import com.innowise.algo.quick.ParallelQuickSort;
import com.innowise.algo.quick.SequentialQuickSort;
import com.innowise.ball.Basketball;
import com.innowise.ball.Cart;

public class App {
    public static void main(String[] args) {
        Cart cart = updateCart();


        cart.sort((t1, t2) -> t1.getLength() > t2.getLength());

        System.out.println(cart);
        cart = updateCart();

        cart.sort((t1, t2) -> t1.getLength() < t2.getLength());

        System.out.println(cart);
        cart = updateCart();

        cart.setSort(new ParallelMergeSort<>((t1, t2) -> t1.getLength() > t2.getLength()));

        cart.sort();

        System.out.println(cart);

        cart.sort((t1, t2) -> t1.getLength() < t2.getLength());

        System.out.println(cart);
        cart = updateCart();

        cart.setSort(new SequentialQuickSort<>((t1, t2) -> t1.getLength() > t2.getLength()));

        cart.sort();
        System.out.println(cart);

        cart.sort((t1, t2) -> t1.getLength() < t2.getLength());
        System.out.println(cart);

        cart = updateCart();

        cart.setSort(new ParallelQuickSort<>((t1, t2) -> t1.getLength() > t2.getLength()));

        cart.sort();
        System.out.println(cart);

        cart.sort((t1, t2) -> t1.getLength() < t2.getLength());
        System.out.println(cart);
    }

    public static Cart updateCart() {
        Cart cart = new Cart();
//
        cart.add(new Basketball(2, 3));
        cart.add(new Basketball(2, 1));
        cart.add(new Basketball(2, 10));
        cart.add(new Basketball(2, 15));
        cart.add(new Basketball(2, 6));
        return cart;
    }
}