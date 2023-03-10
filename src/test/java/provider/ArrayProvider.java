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


    public static Stream<Arguments> unorderedLeftAndRightArrayMerge(){
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

}
