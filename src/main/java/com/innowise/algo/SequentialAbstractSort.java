package com.innowise.algo;

abstract public class SequentialAbstractSort<T> extends AbstractSort<T> {

    public SequentialAbstractSort(BoolComparator<T> comp) {
        super(comp);
    }

    @Override
    protected void compute() {
        throw new UnsupportedOperationException();
    }
}
