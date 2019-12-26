package com.course.msscbrewbery.web.controller.v2;

import com.course.msscbrewbery.services.v2.BeerServiceV2;
import com.course.msscbrewbery.web.model.v2.BeerDtoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private  final BeerServiceV2 beerService;
    @Autowired
    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId")  UUID beeId) {
        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> addBeer(@RequestBody BeerDtoV2 beer) {
        BeerDtoV2 savedBeerDtoV2 = beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v2/beer/" + savedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(savedBeerDtoV2, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> updateBeer(@PathVariable("beerId")UUID uuid, @RequestBody BeerDtoV2 beer) {
        BeerDtoV2 updatedBeerDtoV2 = beerService.updateBeer(uuid, beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v2/beer/" + updatedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(updatedBeerDtoV2, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId")UUID uuid) {
        beerService.deleteBeer(uuid);
    }
}
