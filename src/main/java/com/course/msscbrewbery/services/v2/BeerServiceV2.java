package com.course.msscbrewbery.services.v2;


import com.course.msscbrewbery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID uuid);

    BeerDtoV2 saveBeer(BeerDtoV2 beer);

    BeerDtoV2 updateBeer(UUID uuid, BeerDtoV2 beer);

    void deleteBeer(UUID uuid);
}
