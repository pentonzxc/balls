package com.innowise.ball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FootballTest {
    private Football football;


    @Test
    void whenGetWeight_thenReturnWeight() {
        int expectedWeight = 1;
        football = new Football(null, expectedWeight, 0);

        Assertions.assertThat(football.getWeight()).isEqualTo(expectedWeight);
    }

    @Test
    void whenGetLength_thenReturnLength() {
        int expectedLength = 1;
        football = new Football(null, 0, expectedLength);

        Assertions.assertThat(football.getLength()).isEqualTo(expectedLength);
    }

    @Test
    void whenGetColor_thenReturnColor() {
        Color expectedColor = Color.BLUE;

        football = new Football(expectedColor, 0, 0);

        Assertions.assertThat(football.getColor()).isEqualTo(expectedColor);
    }

    @Test
    void whenType_thenReturnType() {
        football = new Football(null, 0, 0);

        Assertions.assertThat(football.type()).isEqualTo("Football");
    }


    @Test
    void whenToString_thenReturnStringView() {
        football = new Football(null, 0, 0);
        String expected = football.type() +
                " " +
                "Ball{" +
                "weight=" + football.getWeight() +
                ", length=" + football.getLength() +
                ", color=" + football.getColor() +
                '}';


        Assertions.assertThat(football).hasToString(expected);
    }

}