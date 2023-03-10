package com.innowise.ball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketballTest {

    private Basketball basketball;


    @Test
    void whenGetWeight_thenReturnWeight() {
        int expectedWeight = 1;
        basketball = new Basketball(null, expectedWeight, 0);

        Assertions.assertThat(basketball.getWeight()).isEqualTo(expectedWeight);
    }

    @Test
    void whenGetLength_thenReturnLength() {
        int expectedLength = 1;
        basketball = new Basketball(null, 0, expectedLength);

        Assertions.assertThat(basketball.getLength()).isEqualTo(expectedLength);
    }

    @Test
    void whenGetColor_thenReturnColor() {
        Color expectedColor = Color.BLUE;

        basketball = new Basketball(expectedColor, 0, 0);

        Assertions.assertThat(basketball.getColor()).isEqualTo(expectedColor);
    }

    @Test
    void whenType_thenReturnType() {
        basketball = new Basketball(null, 0, 0);

        Assertions.assertThat(basketball.type()).isEqualTo("Basketball");
    }


    @Test
    void whenToString_thenReturnStringView() {
        basketball = new Basketball(null, 0, 0);
        String expected = basketball.type() +
                " " +
                "Ball{" +
                "weight=" + basketball.getWeight() +
                ", length=" + basketball.getLength() +
                ", color=" + basketball.getColor() +
                '}';


        Assertions.assertThat(basketball).hasToString(expected);
    }
}