package com.innowise.algo.quick;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import util.ComparatorUtil;

import static org.junit.jupiter.api.Assertions.*;

class ParallelQuickSortTest {
    private static ParallelQuickSort<Integer> sort;


    @BeforeAll
    static void beforeAll() {
        sort = new ParallelQuickSort<>(ComparatorUtil.aDefault());
    }


    @ParameterizedTest
    @MethodSource("provider.ArrayProvider#sortNaturalOrder")
    void whenSort_thenCheckArrayChangeAsExpected(Integer[] arr, Integer[] expectedArr) {
        sort.sort(arr);

        Assertions.assertThat(arr).isEqualTo(expectedArr);
    }
}