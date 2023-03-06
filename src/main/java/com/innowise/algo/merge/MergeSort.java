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


    @SuppressWarnings("unchecked")
    static <T> ArrayPair<T> splitArray(T[] src) {
        var token = (Class<T>) src.getClass().getComponentType();
        int m = src.length / 2;

        T[] left = array(token, m);
        System.arraycopy(src, 0, left, 0, m);

        T[] right = array(token, src.length - m);
        System.arraycopy(src, m, right, 0, src.length - m);

        return new ArrayPair<>(left, right);
    }


    class ArrayPair<T> {

        T[] left;

        T[] right;

        public ArrayPair(T[] left, T[] right) {
            this.left = left;
            this.right = right;
        }
    }
}
