package com.test.callback.callback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {
    @GetMapping("/")
    public String helloWorld() {
        return "hello world by sean!";
    }

    @GetMapping("/czw-token-callback")
    public String testCallback(@RequestParam String code) {
        return "access token callback - code: {}" + code;
    }
}
