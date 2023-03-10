package com.innowise.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@SuppressWarnings("rawtypes, unchecked")
@ExtendWith(MockitoExtension.class)
class SortTest {

    private static AbstractSort sort;

    @Captor
    private ArgumentCaptor<Object[]> captor;


    @BeforeAll
    static void beforeAll() {
        var fake = new SortFake(null);
        sort = Mockito.spy(fake);
    }


    @Test
    void whenSort_thenCallDoSort() {
        Object[] expectedArray = new Object[]{};

        sort.sort(expectedArray);
        Mockito.verify((SortFake) sort).doSort(captor.capture());

        Assertions.assertSame(expectedArray, captor.getValue());
    }


    @Test
    void whenSetComparator_thenGetComparatorReturnComparator() {
        BoolComparator expected = (obj1, obj2) -> true;
        sort.setComparator(expected);

        Assertions.assertSame(expected, sort.getComparator());
    }


    private static class SortFake extends AbstractSort {

        public SortFake(BoolComparator comp) {
            super(comp);
        }

        @Override
        public void doSort(Object[] src) {
        }

        @Override
        protected void compute() {
        }
    }
}