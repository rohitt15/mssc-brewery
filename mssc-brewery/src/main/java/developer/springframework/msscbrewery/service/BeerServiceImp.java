package developer.springframework.msscbrewery.service;

import developer.springframework.msscbrewery.web.model.BeerDto;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
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

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Hello");
    }
}
