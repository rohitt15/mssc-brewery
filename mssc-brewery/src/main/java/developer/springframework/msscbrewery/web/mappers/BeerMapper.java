package developer.springframework.msscbrewery.web.mappers;

import developer.springframework.msscbrewery.domain.Beer;
import developer.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/*
Created by Rohit on 29-10-21
 */
@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
