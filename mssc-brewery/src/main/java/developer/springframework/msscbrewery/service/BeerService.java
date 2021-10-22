package developer.springframework.msscbrewery.service;

import developer.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto addNewBeer(BeerDto beer);
}

