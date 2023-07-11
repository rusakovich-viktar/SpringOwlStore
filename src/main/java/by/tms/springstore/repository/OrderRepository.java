package by.tms.springstore.repository;

import by.tms.springstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
