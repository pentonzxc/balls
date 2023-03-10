package com.innowise.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.ComparatorUtil;

class BoolComparatorTest {

    private static BoolComparator<Integer> comparator;

    @BeforeAll
    static void beforeAll() {
        comparator = ComparatorUtil.aDefault();
    }


    @Test
    void whenStatementTrue_thenReturnTrue() {
        Assertions.assertTrue(comparator.compare(5, 4));
    }


    @Test
    void whenStatementFalse_thenReturnFalse() {
        Assertions.assertFalse(comparator.compare(4, 5));
    }
}