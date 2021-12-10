package com.ibagroup.carrental.controller.order;

import com.ibagroup.carrental.dto.order.OrderDto;
import com.ibagroup.carrental.model.order.Order;
import com.ibagroup.carrental.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v2/order")
public class OrderController {

    private HashMap<Long, OrderDto> orders = new HashMap<>();

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service){
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addOrder(@RequestBody OrderDto order){
        Order entity = service.addOrder(order);

        return ResponseEntity.ok(entity);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getOrderByUserName(@PathVariable String userName){
        List<Order> orders = service.findOrdersByUserName(userName);

        return ResponseEntity.ok(orders);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = service.findAllOrders();

        return ResponseEntity.ok(orders);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrder(@RequestBody OrderDto order){
        orders.put(order.getId(), order);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrder(@PathVariable Long orderId){
        OrderDto order = orders.remove(orderId);

        return ResponseEntity.ok(order);
    }
}
