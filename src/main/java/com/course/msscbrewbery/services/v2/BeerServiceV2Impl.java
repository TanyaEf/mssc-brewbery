package com.course.msscbrewbery.services.v2;

import com.course.msscbrewbery.web.model.v2.BeerDtoV2;
import com.course.msscbrewbery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID uuid) {
        return BeerDtoV2.builder()
                .uuid(UUID.randomUUID())
                .beerName("GalaxyCat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beer) {
        return BeerDtoV2.builder().uuid(UUID.randomUUID()).build();
    }

    @Override
    public BeerDtoV2 updateBeer(UUID uuid, BeerDtoV2 beer) {
        return BeerDtoV2.builder().uuid(beer.getUuid()).build();
    }

    @Override
    public void deleteBeer(UUID uuid) {
        log.debug("Beer deleted. UUID: " + uuid.toString());
    }
}
