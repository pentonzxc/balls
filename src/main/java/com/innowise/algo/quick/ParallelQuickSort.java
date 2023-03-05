package com.innowise.algo.quick;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.ParallelAbstractSort;

public class ParallelQuickSort<T> extends ParallelAbstractSort<T> implements QuickSort<T> {

    private int left;

    private int right;

    public ParallelQuickSort(BoolComparator<T> comp) {
        super(comp);
    }

    private ParallelQuickSort(T[] src, BoolComparator<T> comp, int left, int right) {
        super(src, comp);
        this.left = left;
        this.right = right;
    }


    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }

    @Override
    protected void doSort(T[] src) {
        left = 0;
        right = src.length - 1;
        super.doSort(src);
    }

    @Override
    protected void compute() {
        if (left >= right) {
            return;
        }

        int pivot = partition(src, left, right);

        var t1 = new ParallelQuickSort<T>(src, comp, left, pivot);
        var t2 = new ParallelQuickSort<T>(src, comp, pivot + 1, right);

        t1.fork();
        t2.compute();
        t1.join();
    }
}
