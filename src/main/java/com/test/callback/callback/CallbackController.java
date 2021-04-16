package com.test.callback.callback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {
    @GetMapping("/")
    public String helloWorld() {
        return "hello world by sean!";
    }

    @GetMapping("/czw-token-callback")
    public String testCallback() {
        System.out.println("======== test access token callback");
        return "access token callback trigerred";
    }
}
