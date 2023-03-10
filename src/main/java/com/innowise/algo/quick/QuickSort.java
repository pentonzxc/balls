package com.innowise.algo.quick;

import com.innowise.algo.BoolComparator;

interface QuickSort<T> {

    BoolComparator<T> comparator();


    default int partition(T[] src, int left, int right) {
        T pivot = src[(left + right) / 2];
        int i = left, j = right;
        while (true) {
            while (comparator().compare(pivot, src[i])) {
                i += 1;
            }

            while (comparator().compare(src[j] , pivot)) {
                j -= 1;
            }

            if (i >= j) {
                return j;
            }

            swap(src, i, j);
            ++i;
            --j;
        }
    }


    private static <T> void swap(T[] src, int i, int j) {
        T tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }
}
