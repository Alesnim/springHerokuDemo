package com.example.demo;

import com.example.demo.repository.CatImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    static CatGetService catGetService;

    @Autowired
    static CatImageRepo catImageRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        catGetService.getUserByIdAsync()
				.subscribe(x -> {
							System.out.println(x.getUrl());
							catImageRepo.save(x);
						}
				);

    }

}
