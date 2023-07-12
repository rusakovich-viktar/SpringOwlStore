package by.tms.springstore.repository;

import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}
