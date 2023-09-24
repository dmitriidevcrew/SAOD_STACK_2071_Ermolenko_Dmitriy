package com.example.SAOD.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/stack")
    public String showStackPage() {
        return "stack";
    }

    @GetMapping("/queue")
    public String showQueuePage() {
        return "queue";
    }
}
