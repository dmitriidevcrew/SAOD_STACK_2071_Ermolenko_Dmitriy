package com.example.SAOD.Stack;

public interface Stack<T> {
    void push(T item) throws Exception;

    T pop() throws Exception;

    T peek() throws Exception;
}
