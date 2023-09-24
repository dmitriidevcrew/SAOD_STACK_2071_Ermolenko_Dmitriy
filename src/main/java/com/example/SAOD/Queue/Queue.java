package com.example.SAOD.Queue;

public interface Queue<T> {
    void enqueue(T item) throws Exception;

    T dequeue() throws Exception;

    T peek() throws Exception;

    T[] toArray();
}
