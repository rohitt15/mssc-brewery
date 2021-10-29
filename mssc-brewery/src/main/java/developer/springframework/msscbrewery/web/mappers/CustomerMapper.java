package developer.springframework.msscbrewery.web.mappers;

import developer.springframework.msscbrewery.domain.Customer;
import developer.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/*
Created by Rohit on 29-10-21
 */

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
