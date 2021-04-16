package com.test.callback.callback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {
    @GetMapping("/")
    public String helloWorld() {
        return "hello world by sean!";
    }

    @GetMapping("/test-callback")
    public void testCallback() {
        System.out.println("==== callback received");
    }
}
