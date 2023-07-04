package com.ChinaMarket.Chinamarket.Controller;

//package com.ChinaMarket.Chinamarket.Controller;

import com.ChinaMarket.Chinamarket.Exception.SellerNotFoundException;
import com.ChinaMarket.Chinamarket.Model.Seller;
import com.ChinaMarket.Chinamarket.RequestDTO.SellerRequestDto;
import com.ChinaMarket.Chinamarket.ResponseDTO.SellerResponseDto;
import com.ChinaMarket.Chinamarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }

    // Get all sellers
    @GetMapping("/get_sellers")
    public List<SellerResponseDto> getAllSellers(){
        return sellerService.getAllSellers();
    }

    // get a seller by PAN Card
    @GetMapping("/get_seller_by_panNo")
    public String getSellerByPanNo(@RequestParam("panNo") int panNo) throws SellerNotFoundException {
        return sellerService.getSellerByPanNo(panNo);
    }

    // find sellers of a particular age
}
