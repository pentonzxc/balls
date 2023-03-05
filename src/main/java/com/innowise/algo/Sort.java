package com.innowise.algo;

import com.innowise.algo.merge.SequentialMergeSort;
import com.innowise.algo.quick.SequentialQuickSort;
import com.innowise.ball.Ball;

public interface Sort<T> {

    void sort(T[] arr);

    void setComparator(BoolComparator<T> comparator);

    static Sort<Ball> defaultBallSort() {
        return new SequentialMergeSort<Ball>((ball , ignore) -> "Basketball".equals(ball.type()));
    }
}
