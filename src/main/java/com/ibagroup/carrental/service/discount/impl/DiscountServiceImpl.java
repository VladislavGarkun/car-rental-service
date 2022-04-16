package com.ibagroup.carrental.service.discount.impl;

import com.ibagroup.carrental.dao.model.discount.Discount;
import com.ibagroup.carrental.dao.repository.dicount.DiscountRepository;
import com.ibagroup.carrental.service.discount.DiscountService;
import com.ibagroup.carrental.service.dto.discount.DiscountDto;
import com.ibagroup.carrental.service.dto.discount.DiscountRegistrationDto;
import com.ibagroup.carrental.service.mapper.discount.DiscountMapper;
import com.ibagroup.carrental.service.mapper.discount.DiscountRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;
    private final DiscountRegistrationMapper discountRegistrationMapper;

    @Override
    public DiscountDto addDiscount(DiscountRegistrationDto discountRegistrationDto) {
        Discount discount = discountRegistrationMapper.toEntity(discountRegistrationDto);

        discountRepository.save(discount);

        return discountMapper.toDto(discount);
    }

    @Override
    public List<DiscountDto> findAllDiscounts() {
        List<Discount> discounts = discountRepository.findAll();

        return discountMapper.toListDto(discounts);
    }

    @Override
    public DiscountDto findDiscountById(Long userId) {
        Discount discount = discountRepository.findById(userId).get();

        return discountMapper.toDto(discount);
    }

    @Override
    public DiscountDto findDiscountByName(String name) {
        Discount discount = discountRepository.findDiscountByName(name);

        return discountMapper.toDto(discount);
    }

    @Override
    public DiscountDto updateDiscount(DiscountDto discountDto) {
        Discount discount = discountMapper.toEntity(discountDto);
        return discountMapper.toDto(discountRepository.save(discount));
    }

    @Override
    public void deleteDiscountById(Long discountId) {
        discountRepository.deleteById(discountId);
    }

}