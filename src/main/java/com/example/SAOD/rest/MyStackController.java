package com.example.SAOD.rest;

import com.example.SAOD.service.MyStackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyStackController {

    private final MyStackService stackService;

    public MyStackController(MyStackService service) {
        stackService = service;
    }

    @PostMapping("/create/{capacity}")
    public HttpStatus create(@PathVariable("capacity") int capacity) {
        return stackService.createStack(capacity);
    }

    @GetMapping("/stack")
    public List<String> getStack() {
        return stackService.getStack();
    }

    @PostMapping("/push")
    public HttpStatusCode push(@RequestBody String item) {
        return stackService.push(item);
    }

    @GetMapping("/pop")
    public ResponseEntity<String> pop() {
        return stackService.pop();
    }

    @GetMapping("/peek")
    public ResponseEntity<String> peek() {
        return stackService.peek();
    }

}
