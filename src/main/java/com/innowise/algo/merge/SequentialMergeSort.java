package com.innowise.algo.merge;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.SequentialAbstractSort;

public class SequentialMergeSort<T> extends SequentialAbstractSort<T> implements MergeSort<T> {

    public SequentialMergeSort(BoolComparator<T> comp) {
        super(comp);
    }

    @Override
    protected void doSort(T[] src) {
        if (src.length < 2) return;

        ArrayPair<T> pair = MergeSort.splitArray(src);

        doSort(pair.left);
        doSort(pair.right);

        merge(src, pair.left, pair.right);
    }


    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }


}
