package com.innowise.algo.merge;


import com.innowise.algo.BoolComparator;
import com.innowise.algo.ParallelAbstractSort;

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

        ArrayPair<T> pair = MergeSort.splitArray(src);

        ParallelMergeSort<T> t1 = new ParallelMergeSort<>(pair.left, comp);
        ParallelMergeSort<T> t2 = new ParallelMergeSort<>(pair.right, comp);

        t1.fork();
        t2.compute();
        t1.join();

        merge(src, pair.left, pair.right);
    }


    @Override
    public BoolComparator<T> comparator() {
        return comp;
    }
}
