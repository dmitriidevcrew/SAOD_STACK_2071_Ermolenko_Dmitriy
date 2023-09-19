package com.example.SAOD.service;

import com.example.SAOD.Queue.MyQueue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyQueueService {
    private MyQueue<String> queue;

    public ResponseEntity<String> createQueue(int capacity) {
        try {
            queue = new MyQueue<>(capacity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public List<String> toArray() {
        return queue.toArray();
    }

    public ResponseEntity<String> enqueue(String item) {
        try {
            queue.enqueue(item);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> dequeue() {
        try {
            return new ResponseEntity<>(queue.dequeue(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> peek() {
        try {
            return new ResponseEntity<>(queue.peek(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
