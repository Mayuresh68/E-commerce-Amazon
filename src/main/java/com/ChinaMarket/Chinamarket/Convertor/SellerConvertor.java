package com.ChinaMarket.Chinamarket.Convertor;

import com.ChinaMarket.Chinamarket.Model.Seller;
import com.ChinaMarket.Chinamarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.Chinamarket.ResponseDTO.SellerResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;


public class SellerConvertor {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){

        return  SellerResponseDto.builder()
                .id(seller.getId())
                .name(seller.getName())
                .mobNo(seller.getMobNo())
                .email(seller.getEmail())
                .build();
    }
}
