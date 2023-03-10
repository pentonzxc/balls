package com.innowise.algo.quick;

import com.innowise.algo.BoolComparator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.ComparatorUtil;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    private static QuickSort<Integer> sort;

    @BeforeAll
    static void beforeAll() {
        sort = new QuickSortFake();
    }

    @Test
    void whenComparator_thenReturnBoolComparator() {
        assertThat(sort.comparator()).isInstanceOf(BoolComparator.class);
    }


    @ParameterizedTest(name = "{0} - source, {1} - expected pivot")
    @MethodSource("com.innowise.algo.quick.QuickSortTest#partitionArguments")
    void whenPartition_thenReturnPivotElement(Integer[] arr, int expectedPivot) {
        Assertions.assertThat(sort.partition(arr, 0, arr.length - 1)).isEqualTo(expectedPivot);
    }


    private static Stream<Arguments> partitionArguments() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 9, 10, 5, 3, 2, 7, 16, 4}, 1),
                Arguments.of(new Integer[]{2, 3, 4, 5, 6, 7, 9}, 3),
                Arguments.of(new Integer[]{10, 5, 3, 2, 1}, 2),
                Arguments.of(new Integer[]{8, 10, 1, 5, 4, 16, 17, 4, 19}, 2)
        );
    }


    private static class QuickSortFake implements QuickSort<Integer> {

        @Override
        public BoolComparator<Integer> comparator() {
            return ComparatorUtil.aDefault();
        }
    }
}