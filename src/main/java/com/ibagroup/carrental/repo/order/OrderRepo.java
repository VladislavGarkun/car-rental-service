package com.ibagroup.carrental.repo.order;

import com.ibagroup.carrental.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface OrderRepo extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order o where o.user.userName = :userName")
    ArrayList<Order> findByUserName(String userName);
}
