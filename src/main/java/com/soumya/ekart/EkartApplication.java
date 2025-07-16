package com.soumya.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@SpringBootApplication
public class EkartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartApplication.class, args);
	}

	@GetMapping("/test")
	public Map<String,String> test(){
		return Map.of("time", LocalDateTime.now().toString(),"message","Application Is Running Fine");
	}
}
