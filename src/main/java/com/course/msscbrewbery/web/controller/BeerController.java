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
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> addBeer(@RequestBody BeerDto beer) {
        BeerDto savedBeerDtoV2 = beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(savedBeerDtoV2, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> updateBeer(@PathVariable("beerId")UUID uuid, @RequestBody BeerDto beer) {
        BeerDto updatedBeerDtoV2 = beerService.updateBeer(uuid, beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + updatedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(updatedBeerDtoV2, httpHeaders, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId")UUID uuid) {
        beerService.deleteBeer(uuid);
    }
}
