package com.innowise.algo.merge;


import com.innowise.algo.BoolComparator;
import com.innowise.algo.ParallelAbstractSort;

import static com.innowise.util.ArrayUtil.array;

public class ParallelMergeSort<T> extends ParallelAbstractSort<T> implements MergeSort<T> {

    public ParallelMergeSort(BoolComparator<T> comp) {
        super(comp);
    }

    private ParallelMergeSort(T[] src, BoolComparator<T> comparator) {
        super(src, comparator);
    }

    @Override
    protected void compute() {
        if (src.length < 2) return;

        int m = src.length / 2;

        T[] left = array(token, m);
        System.arraycopy(src, 0, left, 0, m);

        T[] right = array(token, src.length - m);
        System.arraycopy(src, m, right, 0, src.length - m);

        ParallelMergeSort<T> t1 = new ParallelMergeSort<>(left, comp);
        ParallelMergeSort<T> t2 = new ParallelMergeSort<>(right, comp);

        t1.fork();
        t2.compute();
        t1.join();

        merge(src, left, right);
    }


    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }
}
