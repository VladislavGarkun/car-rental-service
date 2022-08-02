package com.bsuir.carrental.dao.repository.userDiscount;

import com.bsuir.carrental.dao.model.userDiscount.UserDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDiscountRepository extends JpaRepository<UserDiscount, Long> {

    List<UserDiscount> findUserDiscountsByUserId(Long userId);

}