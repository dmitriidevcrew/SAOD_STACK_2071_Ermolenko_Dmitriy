package com.example.SAOD.Queue;

import java.util.List;

public interface Queue<T> {
    void enqueue(T item) throws Exception;

    T dequeue() throws Exception;

    T peek() throws Exception;

    List<String> toArray();
}
