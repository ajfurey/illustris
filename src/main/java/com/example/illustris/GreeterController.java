package com.example.illustris;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeter")
	public Greeter greeter(@RequestParam( value = "name", defaultValue = "World") String name) {
		return new Greeter(counter.incrementAndGet(), String.format(template, name));
	}
}