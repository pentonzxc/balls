package com.innowise.algo.quick;

import com.innowise.algo.BoolComparator;

interface QuickSort<T> {

    BoolComparator<T> comparator();


    default int partition(T[] src, int l, int r) {
        T pivot = src[(l + r) / 2];
        int i = l, j = r;
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
