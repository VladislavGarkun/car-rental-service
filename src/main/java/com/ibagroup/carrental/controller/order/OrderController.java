package com.ibagroup.carrental.controller.order;

import com.ibagroup.carrental.dto.order.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v2/order")
public class OrderController {

    private HashMap<Long, OrderDto> orders = new HashMap<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addOrder(@RequestBody OrderDto order){
        long latestId = orders.size();
        order.setId(latestId);
        orders.put(latestId, order);

        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity getOrderById(@PathVariable Long orderId){
        OrderDto order = orders.get(orderId);

        return ResponseEntity.ok(order);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity updateOrder(@RequestBody OrderDto order){
        orders.put(order.getId(), order);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity deleteOrder(@PathVariable Long orderId){
        OrderDto order = orders.remove(orderId);

        return ResponseEntity.ok(order);
    }
}
