package developer.springframework.msscbrewery.service;

import developer.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id
                (UUID.randomUUID()).name("Ram").build();
    }

    @Override
    public CustomerDto getAddCustomer(CustomerDto customer) {
        return CustomerDto.builder().
                id(UUID.randomUUID()).
                name("shyam").
                build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        log.debug("Updating customer");
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.debug("Deleting the customer: " + id);
    }
}
