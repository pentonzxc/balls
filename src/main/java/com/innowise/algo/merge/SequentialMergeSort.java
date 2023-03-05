package com.innowise.algo.merge;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.SequentialAbstractSort;

import static com.innowise.util.ArrayUtil.array;

public class SequentialMergeSort<T> extends SequentialAbstractSort<T> implements MergeSort<T> {

    public SequentialMergeSort(BoolComparator<T> comp) {
        super(comp);
    }

    @Override
    protected void doSort(T[] src) {
        if (src.length < 2) return;

        int m = src.length / 2;

        T[] left = array(token, m);
        System.arraycopy(src, 0, left, 0, m);

        T[] right = array(token, src.length - m);
        System.arraycopy(src, m, right, 0, src.length - m);

        doSort(left);
        doSort(right);

        merge(src, left, right);
    }


    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }
}
