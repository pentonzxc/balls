package provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ArrayProvider {
    private ArrayProvider() {
    }

    public static Stream<Arguments> orderedLeftAndRightArrayMerge() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 2, 5, 4},
                        new Integer[]{2, 3},
                        new Integer[]{4, 5},
                        new Integer[]{2, 3, 4, 5}
                ),
                Arguments.of(
                        new Integer[]{2, 4, 3},
                        new Integer[]{2},
                        new Integer[]{3, 4},
                        new Integer[]{2, 3, 4}
                )
        );
    }


    public static Stream<Arguments> unorderedLeftAndRightArrayMerge() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 2, 5, 4},
                        new Integer[]{3, 2},
                        new Integer[]{5, 4},
                        new Integer[]{2, 3, 4, 5}
                ),
                Arguments.of(
                        new Integer[]{2, 4, 3},
                        new Integer[]{2},
                        new Integer[]{4, 3},
                        new Integer[]{2, 3, 4}
                )
        );
    }


    public static Stream<Arguments> sortNaturalOrder() {
        return Stream.of(
                Arguments.of(new Integer[]{}, new Integer[]{}),
                Arguments.of(new Integer[]{1}, new Integer[]{1}),
                Arguments.of(new Integer[]{2, 1}, new Integer[]{1, 2}),
                Arguments.of(new Integer[]{1, 1, 1, 1, 1}, new Integer[]{1, 1, 1, 1, 1}),
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new Integer[]{8, 7, 6, 5, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new Integer[]{1, 4, 11, 5, 1, 12, 7, 3, 8}, new Integer[]{1, 1, 3, 4, 5, 7, 8, 11, 12}),
                Arguments.of(
                        new Integer[]{3, 10, 2, 10, 10, 5, 1, 12, 15, 6, 5, 2},
                        new Integer[]{1, 2, 2, 3, 5, 5, 6, 10, 10, 10, 12, 15}
                )
        );
    }
}
