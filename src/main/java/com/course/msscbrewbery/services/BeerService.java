package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID uuid);

    BeerDto saveBeer(BeerDto beer);

    BeerDto updateBeer(UUID uuid, BeerDto beer);

    void deleteBeer(UUID uuid);
}