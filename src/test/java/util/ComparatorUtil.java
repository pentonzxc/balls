package util;

import com.innowise.algo.BoolComparator;
import com.innowise.ball.Ball;

public class ComparatorUtil {
    private ComparatorUtil() {
    }

    public static BoolComparator<Integer> aDefault() {
        return (t1, t2) -> t1 > t2;
    }

    public static BoolComparator<Ball> aBallDefault() {
        return (t1, t2) -> t1.getWeight() > t2.getWeight();
    }
}
