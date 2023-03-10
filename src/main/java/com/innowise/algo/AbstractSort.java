package com.innowise.algo;

import java.util.concurrent.RecursiveAction;

public abstract class AbstractSort<T> extends RecursiveAction implements Sort<T> {

    protected BoolComparator<T> comp;

    protected Class<T> token;

    public AbstractSort(BoolComparator<T> comp) {
        this.comp = comp;
    }


    public void sort(T[] arr) {
        setToken(arr.getClass());
        doSort(arr);
    }


    protected abstract void doSort(T[] src);


    @SuppressWarnings("unchecked")
    protected void setToken(Class<?> tokenClazz) {
        this.token = (Class<T>) tokenClazz.getComponentType();
    }


    public void setComparator(BoolComparator<T> comparator) {
        this.comp = comparator;
    }


    public BoolComparator<T> getComparator() {
        return comp;
    }
}
