package com.innowise.algo.merge;

import com.innowise.algo.BoolComparator;

import static com.innowise.util.ArrayUtil.array;

interface MergeSort<T> {
    BoolComparator<T> comparator();


    default void merge(T[] trg, T[] left, T[] right) {
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            trg[i++] = comparator().compare(right[r], left[l]) ? left[l++] : right[r++];
        }

        while (l < left.length) {
            trg[i++] = left[l++];
        }

        while (r < right.length) {
            trg[i++] = right[r++];
        }
    }
}
