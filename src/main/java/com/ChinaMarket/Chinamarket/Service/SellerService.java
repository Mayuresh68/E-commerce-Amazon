package com.ChinaMarket.Chinamarket.Service;

import com.ChinaMarket.Chinamarket.Convertor.SellerConvertor;
import com.ChinaMarket.Chinamarket.Exception.SellerNotFoundException;
import com.ChinaMarket.Chinamarket.Model.Seller;
import com.ChinaMarket.Chinamarket.Repository.SellerRepository;
import com.ChinaMarket.Chinamarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.Chinamarket.ResponseDTO.SellerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);

        return "Congrats! Now you can sell on Chine Market !!!";
    }

    public List<SellerResponseDto> getAllSellers() {
       List<Seller> sellers = sellerRepository.findAll();
        List<SellerResponseDto> sellerResponseDtos = new ArrayList<>();
       for(Seller s:sellers){
           sellerResponseDtos.add ( SellerConvertor.sellerToSellerResponseDto(s));
       }
       return sellerResponseDtos;


    }

    public String getSellerByPanNo(int panNo) throws SellerNotFoundException {
        Seller seller;
        try{
            seller = sellerRepository.findById(panNo).get();
        }
        catch(Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }
        return seller.getName();
    }
}
