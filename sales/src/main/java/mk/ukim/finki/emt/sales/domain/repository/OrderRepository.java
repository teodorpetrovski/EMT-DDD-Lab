package mk.ukim.finki.emt.sales.domain.repository;

import mk.ukim.finki.emt.sales.domain.models.Order;
import mk.ukim.finki.emt.sales.domain.models.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
