package com.innowise.ball;

import com.innowise.algo.BoolComparator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static class Comparator implements BoolComparator<Ball> {

        private final EnumMap<Color, Integer> order = new EnumMap<>(Color.class);

        public Comparator(List<Color> colorsOrder) {
            fill(colorsOrder);
        }


        public static Comparator aDefault() {
            return new Comparator(Arrays.asList(Color.values()));
        }


        @Override
        public boolean compare(Ball t1, Ball t2) {
            return order.get(t1.getColor()) > order.get(t2.getColor());
        }


        private void fill(List<Color> colors) {
            int minPriority = 0;

            for (int i = minPriority; i < colors.size(); i++) {
                order.put(colors.get(i), i);
            }

            Color[] elems = Color.values();
            if (elems.length != order.size()) {
                for (int i = elems.length - 1; i >= 0; i--) {
                    if (!order.containsKey(elems[i])) {
                        order.put(elems[i], --minPriority);
                    }
                }
            }
        }
    }
}