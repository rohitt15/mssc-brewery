package developer.springframework.msscbrewery.service;

import developer.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImp implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Hadward").beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto addNewBeer(BeerDto beer) {
        return BeerDto.builder().
                id(UUID.randomUUID()).
                build();
    }
}
