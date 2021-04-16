package com.test.callback.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {

    private CallbackService callbackService;

    @Autowired
    public CallbackController(CallbackService callbackService) {
        this.callbackService = callbackService;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "hello world by sean!";
    }

    @GetMapping("/czw-token-callback")
    public String testCallback(@RequestParam(required = false) String code) {
        StringBuilder sb = new StringBuilder("SUCCESS: authorization callback.");
        if (code != null) {
            sb.append(" code: ");
            sb.append(code);
        }
        return sb.toString();
    }
}
