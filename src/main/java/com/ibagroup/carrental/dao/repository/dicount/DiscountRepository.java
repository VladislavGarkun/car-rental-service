package com.ibagroup.carrental.dao.repository.dicount;


import com.ibagroup.carrental.dao.model.discount.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Discount findDiscountByName(String name);

}
