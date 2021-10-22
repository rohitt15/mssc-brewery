package developer.springframework.msscbrewery.web.controller;

import java.util.UUID;

import developer.springframework.msscbrewery.service.BeerService;
import developer.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
private final BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto>getBeer(@PathVariable UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping //create the beer
	public ResponseEntity<BeerDto> addBeer(BeerDto beerDto){
		BeerDto saveDto=beerService.addNewBeer(beerDto);
		HttpHeaders headers=new HttpHeaders();
		//todo add hostname to url
		headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
}
