package com.ChinaMarket.Chinamarket.Service;

import com.ChinaMarket.Chinamarket.Convertor.CustomerConvertor;
import com.ChinaMarket.Chinamarket.Model.Cart;
import com.ChinaMarket.Chinamarket.Model.Customer;
import com.ChinaMarket.Chinamarket.Repository.CustomerRepository;
import com.ChinaMarket.Chinamarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.Chinamarket.Convertor.CustomerConvertor;
import com.ChinaMarket.Chinamarket.ResponseDTO.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequestDto customerRequestDto){

        Customer customer = CustomerConvertor.CustomerRequestDtoToCustomer(customerRequestDto);

        // allocate a cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        // set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);
        return "Congrats !! Welcome to China Market.";
    }

    public CustomerResponseDto getCustomerById(int id){
        Customer customer = customerRepository.findById(id).get();

        //convert cutomer to responseDto
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobNo(customer.getMobNo())
                .build();
        return customerResponseDto;

    }

    public List<CustomerResponseDto> getAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();

        //convet to responseDto
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for(Customer customer : customerList){
            CustomerResponseDto customerResponseDto = CustomerConvertor.CustomerToCustomerResponseDto(customer);

            customerResponseDtoList.add(customerResponseDto);
        }

        return customerResponseDtoList;

    }

    public CustomerResponseDto getCustomerByEmail(String email){
        Customer customer = customerRepository.findByEmail(email);

        //convert cutomer to responseDto
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobNo(customer.getMobNo())
                .build();
        return customerResponseDto;

    }
}
