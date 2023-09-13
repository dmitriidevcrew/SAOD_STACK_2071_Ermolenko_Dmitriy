package com.example.SAOD.service;

import com.example.SAOD.Stack.MyStack;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyStackService {

    private MyStack<String> stack;

    public HttpStatus createStack(int capacity) {
        try {
            stack = new MyStack<>(capacity);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.CONFLICT;
        }
    }

    public List<String> getStack() {
        return stack.getValue();
    }

    public HttpStatus push(String item) {
        try {
            stack.push(item);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.CONFLICT;
        }
    }

    public ResponseEntity<String> pop() {
        try {
            return new ResponseEntity<>(stack.pop(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> peek() {
        try {
            return new ResponseEntity<>(stack.peek(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
