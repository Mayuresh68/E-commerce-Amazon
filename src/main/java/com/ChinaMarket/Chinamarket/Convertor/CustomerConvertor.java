package com.ChinaMarket.Chinamarket.Convertor;

import com.ChinaMarket.Chinamarket.Model.Customer;
import com.ChinaMarket.Chinamarket.RequestDTO.CustomerRequestDto;
import com.ChinaMarket.Chinamarket.ResponseDTO.CustomerResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .id(customer.getId())
                .mobNo(customer.getMobNo())
                .email(customer.getEmail())
                .build();
    }
}
