//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: OrderController

package com.example.illustris.order;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
	public List<Order> getOrders(){
		return orderService.getOrders();
	}

    @PostMapping
    public void registerNewOrder(@RequestBody Order Order){
        orderService.addNewOrder(Order);
    }
    
    @DeleteMapping(path= "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
    }

    @PutMapping(path ="{orderId}")
    public void updateOrder(
        @PathVariable("orderId") Long OrderId,
        @RequestParam(required = false) LocalDateTime dateCreated
    ){
        orderService.uadateOrder(OrderId, dateCreated);
    }
}
