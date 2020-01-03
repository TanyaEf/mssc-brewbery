package com.course.msscbrewbery.domain;

import com.course.msscbrewbery.web.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
    private UUID uuid;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private Timestamp creationDate;
}
