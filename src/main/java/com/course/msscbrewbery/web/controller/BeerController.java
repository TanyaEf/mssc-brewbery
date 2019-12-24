package com.course.msscbrewbery.web.controller;

import com.course.msscbrewbery.services.BeerService;
import com.course.msscbrewbery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private  final BeerService beerService;
    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")  UUID beeId) {
        return new ResponseEntity<BeerDto>(beerService.getBeerById(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> addBeer(BeerDto beer) {
        BeerDto savedBeerDto = beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDto.getUuid().toString());
        return new ResponseEntity<>(savedBeerDto, httpHeaders, HttpStatus.CREATED);
    }
}
