package com.example.SAOD.rest;

import com.example.SAOD.service.MyQueueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queue")
public class MyQueueController {

    private final MyQueueService queueService;

    public MyQueueController(MyQueueService service) {
        this.queueService = service;
    }

    @PostMapping("/create/{capacity}")
    public ResponseEntity<String> create(@PathVariable("capacity") int capacity) {
        return queueService.createQueue(capacity);
    }

    @GetMapping("/toArray")
    public List<String> toArray() {
        return queueService.toArray();
    }

    @PostMapping("/enqueue")
    public ResponseEntity<String> enqueue(@RequestBody String item) {
        return queueService.enqueue(item);
    }

    @GetMapping("/dequeue")
    public ResponseEntity<String> dequeue() {
        return queueService.dequeue();
    }

    @GetMapping("/peek")
    public ResponseEntity<String> peek() {
        return queueService.peek();
    }

    @GetMapping("/check")
    public ResponseEntity<List<String>> check() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
