package com.innowise.algo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SuppressWarnings("rawtypes, unchecked")
class ParallelAbstractSortTest {

    private static ParallelAbstractSort<Object> sort;


    @BeforeAll
    static void beforeAll() {
        var fake = new ParallelSortFake(null);
        sort = Mockito.spy(fake);
    }


    @Test
    void whenDoSort_thenCallCompute() {
        Mockito.doCallRealMethod().when(sort).doSort(Mockito.any());

        sort.doSort(null);

        Mockito.verify((ParallelSortFake) sort, Mockito.times(1)).compute();

    }


    private static class ParallelSortFake extends ParallelAbstractSort {

        public ParallelSortFake(BoolComparator comp) {
            super(comp);
        }

        @Override
        public void compute() {
        }
    }

}