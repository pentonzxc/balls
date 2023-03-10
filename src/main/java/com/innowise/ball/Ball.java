package com.innowise.ball;

import com.innowise.algo.BoolComparator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Ball {

    private int weight;

    private int length;

    private Color color;

    public Ball(Color color, int weight, int length) {
        this.weight = weight;
        this.length = length;
        this.color = color;
    }


    public abstract String type();


    @Override
    public String toString() {
        return "Ball{" +
                "weight=" + weight +
                ", length=" + length +
                ", color=" + color +
                '}';
    }


    public int getWeight() {
        return weight;
    }


    public int getLength() {
        return length;
    }


    public Color getColor() {
        return color;
    }




    public static class ColorComparator implements BoolComparator<Ball> {

        private final EnumMap<Color, Integer> order = new EnumMap<>(Color.class);

        public ColorComparator(List<Color> colorsOrder) {
            fill(colorsOrder);
        }


        public static ColorComparator aDefault() {
            return new ColorComparator(Arrays.asList(Color.values()));
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

        public List<Color> order() {
            return order.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
