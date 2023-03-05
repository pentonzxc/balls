package com.innowise.util;


import java.lang.reflect.Array;

public class ArrayUtil {
    private ArrayUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> clazz, int capacity) {
        return (T[]) Array.newInstance(clazz, capacity);
    }
}
