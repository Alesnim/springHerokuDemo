package com.example.demo.controllers;


import com.example.demo.model.CatImage;
import com.example.demo.repository.CatImageRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CatImageController {

    CatImageRepo catImageRepo;

    @CrossOrigin
    @GetMapping("/cats")
    public @ResponseBody
    List<CatImage> getCats() {
        return StreamSupport.stream(catImageRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
