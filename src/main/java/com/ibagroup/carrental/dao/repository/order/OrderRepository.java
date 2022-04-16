package com.ibagroup.carrental.dao.repository.order;

import com.ibagroup.carrental.dao.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o from Order o where o.user.userName = :userName")
    List<Order> findByUserName(String userName);

}
