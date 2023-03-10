package com.innowise.ball;

import com.innowise.algo.Sort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.ComparatorUtil;

import java.util.Collection;
import java.util.List;


class CartTest {

    private Cart cart;

    @BeforeEach
    void init() {
        cart = new Cart();
    }


    @Test
    void whenSort_thenCallMethodSortClass() {
        var sort = Mockito.spy(Sort.defaultBallSort());
        cart.setSort(sort);
        cart.sort();

        Mockito.verify(sort, Mockito.times(1)).sort(Mockito.any());
    }


    @Test
    void whenSortWithComparator_thenCallSortWithoutComparator() {
        Cart spy = Mockito.spy(Cart.class);
        spy.sort(ComparatorUtil.aBallDefault());

        Mockito.verify(spy, Mockito.times(1)).sort();
    }


    @Test
    void whenAdd_thenGetBallsContainsAdded() {
        Ball added = new Basketball(null, 0, 0);
        cart.add(added);

        Assertions.assertThat(cart.getBalls()).contains(added);
    }


    @Test
    void whenAddAll_thenGetBallsContainsAdded() {
        Collection<Ball> added = List.of(
                new Basketball(null, 0, 0),
                new Basketball(null, 0, 0),
                new Basketball(null, 0, 0)
        );
        cart.addAll(added);

        Assertions.assertThat(cart.getBalls()).containsAll(added);
    }


    @Test
    void whenRemove_thenGetBallsNotContainsRemoved() {
        Ball removed = new Basketball(null, 0, 0);
        cart.add(removed);
        cart.remove(removed);

        Assertions.assertThat(cart.getBalls()).doesNotContain(removed);
    }


    @Test
    void whenToString_thenReturnStringView() {
        Collection<Ball> balls = List.of(
                new Basketball(null, 0, 0),
                new Basketball(null, 0, 0),
                new Basketball(null, 0, 0)
        );
        cart.addAll(balls);

        var expected = "Cart{" +
                "balls=" + balls +
                '}';

        Assertions.assertThat(cart).hasToString(expected);
    }


    @Test
    void whenSetSort_thenGetStrategyReturnSort() {
        var sort = Sort.defaultBallSort();

        cart.setSort(sort);

        Assertions.assertThat(cart.getStrategy()).isSameAs(sort);
    }


    @Test
    void whenEmptyGetStrategy_thenReturnNotNull() {
        Assertions.assertThat(cart.getStrategy()).isNotNull();
    }


    @Test
    void whenGetBalls_thenReturnBalls() {
        Collection<Ball> balls = List.of(new Basketball(null, 0, 0));
        cart = new Cart(balls);

        Assertions.assertThat(cart.getBalls()).isSameAs(balls);
    }


    @Test
    void whenEmptyGetBalls_thenReturnEmptyCollection() {
        Assertions.assertThat(cart.getBalls()).isEmpty();
    }


    @Test
    void whenIterator_thenReturnCollectionIterator() {
        Collection<Ball> balls = List.of(new Basketball(null, 0, 0));
        cart = new Cart(balls);

        Assertions.assertThat(cart.iterator()).isExactlyInstanceOf(balls.iterator().getClass());
    }
}