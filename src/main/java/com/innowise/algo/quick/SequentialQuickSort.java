package com.innowise.algo.quick;

import com.innowise.algo.BoolComparator;
import com.innowise.algo.SequentialAbstractSort;

public class SequentialQuickSort<T> extends SequentialAbstractSort<T> implements QuickSort<T> {

    public SequentialQuickSort(BoolComparator<T> comp) {
        super(comp);
    }


    @Override
    protected void doSort(T[] src) {
        quicksort(src , 0 , src.length - 1);
    }

    protected void quicksort(T[] src, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(src, l, r);

        quicksort(src, l, pivot);

        quicksort(src, pivot + 1, r);
    }

    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }
}
