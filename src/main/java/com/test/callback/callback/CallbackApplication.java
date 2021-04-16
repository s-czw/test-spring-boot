package com.test.callback.callback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallbackApplication.class, args);
	}

}

@RestController
class CallbackController {
	@GetMapping("/")
	String helloWorld() {
		return "hello world by sean!";
	}
}