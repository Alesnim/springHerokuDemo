package com.example.demo.repository;

import com.example.demo.model.CatImage;
import org.springframework.data.repository.CrudRepository;

public interface CatImageRepo extends CrudRepository<CatImage, Long> {

    CatImage findCatImageById(long id);

}
