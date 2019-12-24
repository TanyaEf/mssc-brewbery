package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.BeerDto;

public interface BeerService {
    BeerDto getBeerById();

    BeerDto saveBeer(BeerDto beer);
}
