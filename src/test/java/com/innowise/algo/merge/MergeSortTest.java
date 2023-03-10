package com.innowise.algo.merge;

import com.innowise.algo.BoolComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    private MergeSort<Integer> sort = new MergeSortWrapper<>();

    @Test
    void whenComparator_thenReturnBoolComparator() {
        assertThat(sort.comparator()).isInstanceOf(BoolComparator.class);
    }

    @ParameterizedTest(name = "{index} - {0} - source, {1} - left, {2} - right, {3} - expected")
    @MethodSource("provider.ArrayProvider#orderedLeftAndRightArrayMerge")
    void whenMergeOrderedLeftAndRight_checkArrayChangeAsExpected(Integer[] trg,
                                                                 Integer[] left,
                                                                 Integer[] right,
                                                                 Integer[] expected) {
        sort.merge(trg, left, right);

        assertThat(trg).isEqualTo(expected);
    }


    @ParameterizedTest(name = "{index} - {0} - source, {1} - left, {2} - right, {3} - not expected")
    @MethodSource("provider.ArrayProvider#unorderedLeftAndRightArrayMerge")
    void whenMergeOrderedLeftAndRight_checkArrayChangeAsNotExpected(Integer[] trg,
                                                                    Integer[] left,
                                                                    Integer[] right,
                                                                    Integer[] expected) {
        sort.merge(trg, left, right);

        assertThat(trg).isNotEqualTo(expected);
    }


    private class MergeSortWrapper<T> implements MergeSort<T> {

        @Override
        public BoolComparator<T> comparator() {
            return (t1, t2) -> true;
        }
    }


}