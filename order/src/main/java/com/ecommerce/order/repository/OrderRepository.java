package com.ecommerce.order.repository;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    @Modifying
    @Query("UPDATE Order o SET o.status = :status WHERE o.orderId = :orderId")
    int updateStatus(@Param("orderId") Long orderId, @Param("status") OrderStatus status);

}
