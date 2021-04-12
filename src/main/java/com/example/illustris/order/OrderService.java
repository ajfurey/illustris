//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: OrderService

package com.example.illustris.order;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order findOrder(Long id) {
		return orderRepository.find(id);
		
	}

    public void addNewOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.
        findOrderByID(order.getId());
		if (orderOptional.isPresent()) {
			throw new IllegalStateException("id already exists");//TODO: use an error message
		}
		orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists=orderRepository.existsById(orderId);
		if (!exists) {
			throw new IllegalStateException("order with id "+ orderId + " does not exist");//TODO: use an error message
		}
		orderRepository.deleteById(orderId);
    }

    //TODO:create uadateOrder() method
    @Transactional
    public void uadateOrder(Long orderId, LocalDateTime dateCreated) {
		
    }
}
