package com.ibagroup.carrental.endpoint.discount;

import com.ibagroup.carrental.service.discount.DiscountService;
import com.ibagroup.carrental.service.dto.discount.DiscountDto;
import com.ibagroup.carrental.service.dto.discount.DiscountRegistrationDto;
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

    private final DiscountService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDiscount(@RequestBody DiscountRegistrationDto discountRegistrationDto){
        DiscountDto discountDto = service.addDiscount(discountRegistrationDto);

        return ResponseEntity.ok(discountDto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DiscountDto> getAllDiscounts(){
        return service.findAllDiscounts();
    }

    @GetMapping(value = "/{discountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DiscountDto getDiscountById(@PathVariable("discountId") Long userId){
        return service.findDiscountById(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DiscountDto getDiscountByName(@RequestParam String name){
        return service.findDiscountByName(name);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DiscountDto updateDiscount(@RequestBody DiscountDto discountDto){
        return service.updateDiscount(discountDto);
    }

    @DeleteMapping(value = "/{discountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteDiscountById(@PathVariable("discountId") Long discountId){
        service.deleteDiscountById(discountId);
    }

}
