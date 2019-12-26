package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID uuid) {
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

    @Override
    public BeerDto updateBeer(UUID uuid, BeerDto beer) {
        return BeerDto.builder().uuid(beer.getUuid()).build();
    }

    @Override
    public void deleteBeer(UUID uuid) {
        log.debug("Beer deleted. UUID: " + uuid.toString());
    }
}
