package developer.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.time.OffsetDateTime;
import java.util.UUID;

/*
 Created by Rohit on 21-10-2021*
 Modified by Rohit on 28-10-2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	@Null
	private UUID id;
	@NotBlank
	private String beerName;
	private String beerStyle;

	@Positive
	private Long upc;

	private OffsetDateTime createdDate;
	private OffsetDateTime lastUpdatedDate;
}
