package com.course.msscbrewbery.web.controller.v2;

import com.course.msscbrewbery.services.v2.BeerServiceV2;
import com.course.msscbrewbery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/beer")
@RestController
@Slf4j
@RequiredArgsConstructor
public class BeerControllerV2 {
    private  final BeerServiceV2 beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@Valid @NotNull @PathVariable("beerId")  UUID beeId) {
        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> addBeer(@Valid @NotNull @RequestBody BeerDtoV2 beer) {
        log.debug("Posted new beer");
        BeerDtoV2 savedBeerDtoV2 = beerService.saveBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v2/beer/" + savedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(savedBeerDtoV2, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> updateBeer(@NotNull @PathVariable("beerId")UUID uuid, @Valid @NotNull@RequestBody BeerDtoV2 beer) {
        BeerDtoV2 updatedBeerDtoV2 = beerService.updateBeer(uuid, beer);
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Location", "/api/v2/beer/" + updatedBeerDtoV2.getUuid().toString());
        return new ResponseEntity<>(updatedBeerDtoV2, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@NotNull @PathVariable("beerId")UUID uuid) {
        beerService.deleteBeer(uuid);
    }


}
