package developer.springframework.msscbrewery.service;



import developer.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    public CustomerDto getCustomerById(UUID customerId);

    public CustomerDto getAddCustomer(CustomerDto customer);

    void updateCustomer(UUID id, CustomerDto customerDto);

    void deleteCustomer(UUID id);
}
