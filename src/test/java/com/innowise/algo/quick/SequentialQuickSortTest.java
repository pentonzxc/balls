package com.innowise.algo.quick;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import util.ComparatorUtil;

class SequentialQuickSortTest {

    private static SequentialQuickSort<Integer> sort;


    @BeforeAll
    static void beforeAll() {
        var fake = new SequentialQuickSortFake();
        sort = Mockito.spy(fake);
    }


    @Test
    void whenDoSort_thenCallQuickSort() {
        Integer[] arr = new Integer[]{1, 2, 3};
        ((SequentialQuickSortFake) sort).doSort(arr);

        Mockito.verify((SequentialQuickSortFake) sort, Mockito.times(1)).quicksort(arr, 0, arr.length - 1);
    }


    @ParameterizedTest
    @MethodSource("provider.ArrayProvider#sortNaturalOrder")
    void whenSort_thenCheckArrayChangeAsExpected(Integer[] arr, Integer[] expectedArr) {
        sort.sort(arr);

        Assertions.assertThat(arr).isEqualTo(expectedArr);
    }


    private static class SequentialQuickSortFake extends SequentialQuickSort<Integer> {

        public SequentialQuickSortFake() {
            super(ComparatorUtil.aDefault());
        }

        @Override
        public void doSort(Integer[] src) {
            super.doSort(src);
        }

        @Override
        public void quicksort(Integer[] src, int left, int right) {
            super.quicksort(src, left, right);
        }
    }
}