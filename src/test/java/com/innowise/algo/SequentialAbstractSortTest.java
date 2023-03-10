package com.innowise.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class SequentialAbstractSortTest {

    @Mock
    private SequentialAbstractSort<Object> sort;


    @Test
    void whenCompute_thenThrowsUnsupportedOperationException() {
        Mockito.doCallRealMethod().when(sort).compute();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> sort.compute());
    }

}