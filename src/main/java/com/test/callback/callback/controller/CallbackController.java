package com.test.callback.callback.controller;

import com.test.callback.callback.service.CallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CallbackController {
    final Logger logger = LoggerFactory.getLogger(CallbackController.class);

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
    public String testCallback(@RequestParam(required = false) String code, HttpServletRequest request) {
        logger.info("=================================================");
        logger.info("============ Token Callback received ============");
        logger.info("{}", request.getRequestURL());
        StringBuilder sb = new StringBuilder("SUCCESS: authorization callback.");
        if (code != null) {
            sb.append(" code: ");
            sb.append(code);
            callbackService.createLazopAccessToken(code);
        }
        return sb.toString();
    }
}
