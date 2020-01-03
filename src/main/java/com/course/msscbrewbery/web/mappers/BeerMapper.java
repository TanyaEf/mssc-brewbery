package com.course.msscbrewbery.web.mappers;

import com.course.msscbrewbery.domain.Beer;
import com.course.msscbrewbery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
