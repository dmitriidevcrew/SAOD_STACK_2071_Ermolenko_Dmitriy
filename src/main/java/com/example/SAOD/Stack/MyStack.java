package com.example.SAOD.Stack;

public class MyStack<T> implements Stack<T> {
    private final T[] array;
    private int count = 0;

    public T[] getValue() {
        return array;
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
