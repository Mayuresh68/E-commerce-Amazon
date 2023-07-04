package com.ChinaMarket.Chinamarket.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerResponseDto {

    int id;

    private String name;

    private String email;

    private String mobNo;

    private String panNo;
}
