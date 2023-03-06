package com.innowise.algo;

public abstract class ParallelAbstractSort<T> extends AbstractSort<T> {
    protected T[] src;

    public ParallelAbstractSort(BoolComparator<T> comp) {
        super(comp);
    }

    public ParallelAbstractSort(T[] src, BoolComparator<T> comp) {
        super(comp);
        setArray(src);
        setToken(src.getClass());
    }


    @Override
    protected void doSort(T[] src) {
        compute();
    }

    @Override
    public void sort(T[] arr) {
        setArray(arr);
        super.sort(arr);
    }

    private void setArray(T[] arr) {
        this.src = arr;
    }
}
