package com.example.SAOD.Queue;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyQueue<T> implements Queue<T> {
    private final int capacity;
    private int count;
    private boolean isEmpty;
    private T[] array;

    @Getter
    private int currentIn, currentOut;

    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        isEmpty = true;
        int count, currentIn, currentOut = 0;
    }

    @Override
    public void enqueue(T item) throws Exception {
        if (count >= capacity) throw new Exception();
        array[currentIn] = item;
        count++;
        currentIn = inc(currentIn ,capacity);
        isEmpty = false;
    }

    @Override
    public T dequeue() throws Exception {
        if (count <= 0) throw new Exception();
        count--;
        if (count == 0) isEmpty = true;
        T item = array[currentOut];
        array[currentOut] = null;
        currentOut = inc(currentOut ,capacity);
        return item;
    }

    @Override
    public T peek() throws Exception {
        if (count <= 0) throw new Exception();
        return array[currentOut];
    }

    private int inc(int i, int modulus) {
        if (++i >= modulus) i = 0;
        return i;
    }

    @Override
    public List<String> toArray() {
        return Arrays.stream(array).filter(Objects::nonNull).map(Object::toString).toList();
    }
}
