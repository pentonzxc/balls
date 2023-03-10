package com.innowise.algo.merge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.ComparatorUtil;

import static org.junit.jupiter.api.Assertions.*;

class ParallelMergeSortTest {

    private static ParallelMergeSort<Integer> sort;


    @BeforeAll
    static void beforeAll() {
        sort = new ParallelMergeSort<>(ComparatorUtil.aDefault());
    }


    @ParameterizedTest
    @MethodSource("provider.ArrayProvider#sortNaturalOrder")
    void whenSort_thenCheckArrayChangeAsExpected(Integer[] arr, Integer[] expectedArr) {
        sort.sort(arr);

        Assertions.assertThat(arr).isEqualTo(expectedArr);
    }
}