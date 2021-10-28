package developer.springframework.msscbrewery.web.controller;

import developer.springframework.msscbrewery.service.CustomerService;
import developer.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1//customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.getAddCustomer(customerDto);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1//customer" + customer.getUuid().toString());
        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @PutMapping("{/customerId}")
    public ResponseEntity headerUpdate(@PathVariable("customerId") UUID customerId,@Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@Valid @PathVariable("id") UUID id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validateErrorHandling(ConstraintViolationException e){

        List<String> error=new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation ->
                error.add(constraintViolation.getPropertyPath()+" : " + constraintViolation.getMessage()));
        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
