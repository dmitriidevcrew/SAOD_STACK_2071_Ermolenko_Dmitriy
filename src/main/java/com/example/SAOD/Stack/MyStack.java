package com.example.SAOD.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyStack<T> implements Stack<T> {
    private final T[] array;
    private int count = 0;

    public List<String> getValue() {
        return Arrays.stream(array).filter(Objects::nonNull).map(Object::toString).toList();
    }

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) throws Exception {
        if (count > array.length) throw new Exception();
        array[count] = item;
        count++;
    }

    @Override
    public T pop() throws Exception {
        if (count <= 0) throw new Exception();
        T item = array[count - 1];
        array[count - 1] = null;
        count--;
        return item;
    }

    @Override
    public T peek() throws Exception {
        if (count <= 0) throw new Exception();
        return array[count - 1];
    }
}
