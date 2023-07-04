package com.ChinaMarket.Chinamarket.Controller;

//package com.ChinaMarket.Chinamarket.Controller;

import com.ChinaMarket.Chinamarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.Chinamarket.ResponseDTO.CustomerResponseDto;
import com.ChinaMarket.Chinamarket.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.addCustomer(customerRequestDto);
    }

    // get customer by id
    @GetMapping("/get-customer")
    public ResponseEntity getCustomerById(@RequestParam("id") int id){
        CustomerResponseDto customerResponseDto = customerService.getCustomerById(id);
        return new ResponseEntity(customerResponseDto, HttpStatus.FOUND);
    }

    // view all customers
    @GetMapping("/get-all-customers")
    public List<CustomerResponseDto> getAllCustomers(){
         return  customerService.getAllCustomers();
    }

    // delete customer by id

    // get a customer by email
    @GetMapping("/get-customer-by-email")
    public ResponseEntity getCustomerByEmail(@RequestParam("email") String email){
        CustomerResponseDto customerResponseDto = customerService.getCustomerByEmail(email);
        return new ResponseEntity(customerResponseDto, HttpStatus.FOUND);
    }

    // update customer
}
