package com.example.demo.controllers;


import com.example.demo.CatGetService;
import com.example.demo.model.CatImage;
import com.example.demo.repository.CatImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CatImageController {

    @Autowired
    CatGetService catGetService;
    @Autowired
    CatImageRepo catImageRepo;


    @CrossOrigin
    @GetMapping("/cats")
    public @ResponseBody
    List<CatImage> getCats() {
        catGetService.getUserByIdAsync()
                .subscribe(x -> {
                            System.out.println(x.getUrl());
                            catImageRepo.save(x);
                        }
                );

        return StreamSupport.stream(catImageRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    @CrossOrigin
    @GetMapping("/cat/random")
    public @ResponseBody
    CatImage getRandomCat() {
        Random random = new Random();
        List<CatImage> imgs = StreamSupport
                .stream(catImageRepo
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());

        return imgs.get(random.nextInt(imgs.size()));
    }

}
