//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: OrderRepository
package com.example.illustris.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //SELECT * FROM student WHERE email= ?
    @Query("SELECT s FROM Order s WHERE s.id = ?1")//Order is class name not db
    Optional<Order> findOrderByID(Long id);
}
