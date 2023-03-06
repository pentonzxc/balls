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

    protected void quicksort(T[] src, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(src, left, right);

        quicksort(src, left, pivot);
        quicksort(src, pivot + 1, right);
    }

    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }
}
