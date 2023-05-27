package mk.ukim.finki.emt.sales.services;

import mk.ukim.finki.emt.sales.domain.exceptions.OrderItemNotFoundException;
import mk.ukim.finki.emt.sales.domain.exceptions.OrderNotFoundException;
import mk.ukim.finki.emt.sales.domain.models.Order;
import mk.ukim.finki.emt.sales.domain.models.OrderId;
import mk.ukim.finki.emt.sales.domain.models.OrderItem;
import mk.ukim.finki.emt.sales.domain.models.OrderItemId;
import mk.ukim.finki.emt.sales.services.forms.OrderForm;
import mk.ukim.finki.emt.sales.services.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder( OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId orderId);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderNotFoundException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderNotFoundException, OrderItemNotFoundException;
}
