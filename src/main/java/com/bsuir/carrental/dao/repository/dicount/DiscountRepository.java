package com.bsuir.carrental.dao.repository.dicount;


import com.bsuir.carrental.dao.model.discount.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Discount findDiscountByName(String name);

    List<Discount> findDiscountsByIdIn(List<Long> id);

}
