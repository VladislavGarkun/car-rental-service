package com.bsuir.carrental.endpoint.discount;

import com.bsuir.carrental.domain.dto.discount.DiscountDto;
import com.bsuir.carrental.service.discount.DiscountService;
import com.bsuir.carrental.domain.dto.discount.DiscountRegistrationDto;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/discount")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDiscount(@RequestBody DiscountRegistrationDto discountRegistrationDto){
        ResponseEntity response = discountService.addDiscount(discountRegistrationDto);

        return response;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DiscountDto> getAllDiscounts(){
        return discountService.findAllDiscounts();
    }

    @PostMapping(value = "/give", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity giveDiscount(@RequestBody UserDiscountRegistrationDto userDiscountRegistrationDto){
        return discountService.giveDiscount(userDiscountRegistrationDto);
    }

}