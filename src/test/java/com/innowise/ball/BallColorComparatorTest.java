package com.innowise.ball;

import com.innowise.ball.Ball.ColorComparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BallColorComparatorTest {
    private ColorComparator comparator;


    @Test
    void whenADefault_thenReturnComparatorWithColorEnumDefinedOrder() {
        comparator = ColorComparator.aDefault();
        var expectedOrder = Color.values();

        Assertions.assertThat(comparator.order().toArray()).isEqualTo(expectedOrder);
    }


    @ParameterizedTest
    @MethodSource("provider.ColorProvider#orders")
    void whenCreate_thenReturnOrder(List<Color> given, List<Color> expectedOrder) {
        comparator = new ColorComparator(given);

        Assertions.assertThat(comparator.order()).isEqualTo(expectedOrder);
    }


    @ParameterizedTest(name = "order - {0} , expected - {2}}")
    @MethodSource("provider.ColorProvider#sortColorOrder")
    void whenSortByColorComparator_thenCheckArrayChangeAsExpected(List<Color> given,
                                                                  List<Ball> balls,
                                                                  List<Color> expected) {
        comparator = new ColorComparator(given);
        Cart cart = new Cart(balls);
        cart.sort(comparator);

        Assertions.assertThatStream(cart.getBalls().stream()).map(Ball::getColor).isEqualTo(expected);
    }
}
