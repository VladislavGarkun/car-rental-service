package com.bsuir.carrental.domain.mapper.userDiscount.impl;

import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import com.bsuir.carrental.dao.repository.dicount.DiscountRepository;
import com.bsuir.carrental.dao.repository.user.UserRepository;
import com.bsuir.carrental.domain.dto.userDiscount.UserDiscountRegistrationDto;
import com.bsuir.carrental.domain.mapper.userDiscount.UserDiscountRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDiscountRegistrationMapperImpl implements UserDiscountRegistrationMapper {

    private final UserRepository userRepository;
    private final DiscountRepository discountRepository;

    @Override
    public UserDiscount toEntity(UserDiscountRegistrationDto userDiscountRegistrationDto){
        UserDiscount userDiscount = new UserDiscount();

        userDiscount.setUser(userRepository.findById(userDiscountRegistrationDto.getUserId()).get());
        userDiscount.setDiscount(discountRepository.findById(userDiscountRegistrationDto.getDiscountId()).get());
        userDiscount.setDateOfStart(userDiscountRegistrationDto.getDateOfStart());
        userDiscount.setDateOfEnd(userDiscountRegistrationDto.getDateOfEnd());

        return userDiscount;
    }

}