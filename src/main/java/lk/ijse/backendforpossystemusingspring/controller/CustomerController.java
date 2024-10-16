package lk.ijse.backendforpossystemusingspring.controller;

import lk.ijse.backendforpossystemusingspring.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.backendforpossystemusingspring.dto.CustomerStatus;
import lk.ijse.backendforpossystemusingspring.dto.SuperDTO;
import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;
import lk.ijse.backendforpossystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.backendforpossystemusingspring.exception.DataPersistException;
import lk.ijse.backendforpossystemusingspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDto) {

           /* customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);*/
        try {
            customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping(value = "/{customerId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") String customerId, @RequestBody CustomerDTO customerDto){
        /*customerService.updateCustomer(customerDto);*/
        String regexForUserID = "^C\\d{3}$\n";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(customerId);
        customerService.updateCustomer(customerId,customerDto);
        try {
            if(!regexMatcher.matches() || customerDto == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(customerId,customerDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{customerId}")
    public  ResponseEntity<Void> deleteCustomer(@PathVariable ("customerId") String customerId){
        String regexForUserID = "^C\\d{3}$\n";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        var regexMatcher = regexPattern.matcher(customerId);
        customerService.deleteCustomer(customerId);
        try {
            if (!regexMatcher.matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable("customerId") String customerId){
       String regexForCustomerId = "^C\\d{3}$";
        Pattern regexPattern = Pattern.compile(regexForCustomerId);
        var regexMatcher = regexPattern.matcher(customerId);
        if (!regexMatcher.matches()) {
            return  new SelectedCustomerErrorStatus(1,"Note ID is not valid");
        }
        return customerService.getSelectedCustomer(customerId);

    }
}
