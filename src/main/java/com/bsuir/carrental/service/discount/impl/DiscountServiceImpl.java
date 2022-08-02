package com.bsuir.carrental.service.discount.impl;

import com.bsuir.carrental.dao.model.discount.Discount;
import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import com.bsuir.carrental.dao.repository.dicount.DiscountRepository;
import com.bsuir.carrental.dao.repository.userDiscount.UserDiscountRepository;
import com.bsuir.carrental.domain.dto.discount.DiscountDto;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountDto;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountRegistrationDto;
import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.service.discount.DiscountService;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.discount.DiscountRegistrationDto;
import com.bsuir.carrental.domain.mapper.discount.DiscountMapper;
import com.bsuir.carrental.domain.mapper.discount.DiscountRegistrationMapper;
import com.bsuir.carrental.domain.mapper.user.UserMapper;
import com.bsuir.carrental.domain.mapper.userDiscount.UserDiscountMapper;
import com.bsuir.carrental.domain.mapper.userDiscount.UserDiscountRegistrationMapper;
import com.bsuir.carrental.domain.mapper.userRole.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;
    private final DiscountRegistrationMapper discountRegistrationMapper;
    private final UserDiscountRepository userDiscountRepository;
    private final UserDiscountMapper userDiscountMapper;
    private final UserDiscountRegistrationMapper userDiscountRegistrationMapper;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    @Override
    public ResponseEntity addDiscount(DiscountRegistrationDto discountRegistrationDto) {
        if(discountRegistrationDto.getName().isEmpty() || discountRegistrationDto.getValue() == null){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }
        if(discountRegistrationDto.getValue() >= 100 || discountRegistrationDto.getValue() <= 0){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DISCOUNT_VALUE.getMessage()));
        }

        Discount discount = discountRegistrationMapper.toEntity(discountRegistrationDto);

        discountRepository.save(discount);

        return ResponseEntity.ok(discountMapper.toDto(discount));
    }

    @Override
    public List<DiscountDto> findAllDiscounts() {
        List<Discount> discounts = discountRepository.findAll();

        return discountMapper.toListDto(discounts);
    }

    @Override
    public ResponseEntity giveDiscount(UserDiscountRegistrationDto userDiscountRegistrationDto){
        if (userDiscountRegistrationDto.getDateOfStart().isAfter(userDiscountRegistrationDto.getDateOfEnd())){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.DATE_MISMATCH.getMessage()));
        }
        UserDiscount userDiscount = userDiscountRegistrationMapper.toEntity(userDiscountRegistrationDto);

        UserDiscount savedUserDiscount = userDiscountRepository.save(userDiscount);

        UserDiscountDto userDiscountDto = userDiscountMapper.toDto(savedUserDiscount);
        userDiscountDto.setUser(userMapper.toDto(savedUserDiscount.getUser()));
        userDiscountDto.getUser().setUserRole(userRoleMapper.toDto(savedUserDiscount.getUser().getUserRole()));
        userDiscountDto.setDiscount(discountMapper.toDto(savedUserDiscount.getDiscount()));

        return ResponseEntity.ok(userDiscountDto);
    }

}