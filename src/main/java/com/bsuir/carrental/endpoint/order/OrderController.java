package com.bsuir.carrental.endpoint.order;

import com.bsuir.carrental.domain.dto.order.OrderRegistrationDto;
import com.bsuir.carrental.service.order.OrderService;
import com.bsuir.carrental.domain.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addOrder(@RequestBody OrderRegistrationDto orderRegistrationDto){
        return orderService.addOrder(orderRegistrationDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderByUserName(@RequestParam String userName){
        List<OrderDto> orderDtoList = orderService.findOrdersByUserName(userName);

        return ResponseEntity.ok(orderDtoList);
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrdersByUserId(@PathVariable("orderId") Long orderId){
        OrderDto orderDto = orderService.findOrderById(orderId);

        return ResponseEntity.ok(orderDto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllOrders(){
        List<OrderDto> orderDtoList = orderService.findAllOrders();

        return ResponseEntity.ok(orderDtoList);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrderById(@RequestBody OrderDto orderDto){
        OrderDto response = orderService.updateOrder(orderDto);

        return ResponseEntity.ok(response);
    }

}