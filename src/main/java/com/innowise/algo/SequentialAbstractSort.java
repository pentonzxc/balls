package com.innowise.algo;

public abstract class SequentialAbstractSort<T> extends AbstractSort<T> {

    public SequentialAbstractSort(BoolComparator<T> comp) {
        super(comp);
    }

    @Override
    protected void compute() {
        throw new UnsupportedOperationException();
    }
}
