package com.ibagroup.carrental.service.order;

import com.ibagroup.carrental.dto.order.OrderDto;
import com.ibagroup.carrental.model.order.Order;
import com.ibagroup.carrental.model.order.OrderStatus;
import com.ibagroup.carrental.repo.car.CarRepo;
import com.ibagroup.carrental.repo.order.OrderRepo;
import com.ibagroup.carrental.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repo;
    private final UserRepo userRepo;
    private final CarRepo carRepo;

    @Autowired
    public OrderService(OrderRepo repo, UserRepo userRepo, CarRepo carRepo){
        this.repo = repo;
        this.userRepo = userRepo;
        this.carRepo = carRepo;
    }


    public Order addOrder(OrderDto order) {

        Order entity = new Order();
        entity.setUser(userRepo.findByUserName(order.getUserName()));
        entity.setCar(carRepo.findById(order.getCarId()).get());
        entity.setStartDate(order.getStartDate());
        entity.setEndDate(order.getEndDate());
        entity.setPrice(calculationPrice(order));
        entity.setStatus(OrderStatus.ACTIVE);

        repo.save(entity);

        return entity;
    }

    private Float calculationPrice(OrderDto order) {
        Long period = ChronoUnit.DAYS.between(order.getStartDate(), order.getEndDate()) + 1;

        Float price = carRepo.findById(order.getCarId()).get().getPrice();
        return period * price;
    }

    public ArrayList<Order> findOrdersByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    public List<Order> findAllOrders() {
        return repo.findAll();
    }
}
