package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById() {
        return BeerDto.builder()
                .uuid(UUID.randomUUID())
                .beerName("GalaxyCat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {
        return BeerDto.builder().uuid(UUID.randomUUID()).build();
    }
}
