package com.innowise.algo;

public interface Sort<T> {

    void sort(T[] arr);

    void setComparator(BoolComparator<T> comparator);
}
