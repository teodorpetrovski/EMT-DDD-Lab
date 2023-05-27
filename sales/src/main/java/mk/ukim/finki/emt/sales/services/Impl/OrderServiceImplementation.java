package mk.ukim.finki.emt.sales.services.Impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt.sales.domain.exceptions.OrderItemNotFoundException;
import mk.ukim.finki.emt.sales.domain.exceptions.OrderNotFoundException;
import mk.ukim.finki.emt.sales.domain.models.*;
import mk.ukim.finki.emt.sales.domain.repository.OrderRepository;
import mk.ukim.finki.emt.sales.services.OrderService;
import mk.ukim.finki.emt.sales.services.forms.OrderForm;
import mk.ukim.finki.emt.sales.services.forms.OrderItemForm;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

import javax.validation.Validation;
import javax.validation.Validator;


import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImplementation implements OrderService
{

    private final OrderRepository orderRepository;
    private final DomainEventPublisher domainEventPublisher;
    private static final Validator validator =
            Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory()
                    .getValidator();

    public OrderServiceImplementation(OrderRepository orderRepository, DomainEventPublisher domainEventPublisher) {
        this.orderRepository = orderRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm,"Order Form must not be null");
        var contraintsViolations=validator.validate(orderForm);
        if(contraintsViolations.size()>0)
            throw new ConstraintViolationException("This order form is not valid",contraintsViolations);

        var order=this.orderRepository.saveAndFlush(toDomainObject(orderForm));
        order.getOrderItemList().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getProduct().getId(),item.getQuantity())));
        return order.getId();


    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return this.orderRepository.findById(orderId);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderNotFoundException {
        Order order=this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        order.addItem(orderItemForm.getProduct(), orderItemForm.getQuantity());
        domainEventPublisher.publish(new OrderItemCreated(orderItemForm.getProduct().getProductId().getId(),orderItemForm.getQuantity()));

        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderNotFoundException, OrderItemNotFoundException {
        Order order=this.orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        order.removeItem(orderItemId);

        this.orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm)
    {
        TrackingDetails trackingDetails=new TrackingDetails(orderForm.getTrackingDetails().getCourierName(),orderForm.getTrackingDetails().getTrackingNumber());
        ShippingDetails shippingDetails=new ShippingDetails(orderForm.getShippingDetails().getAddress(), orderForm.getShippingDetails().getZipCode());
        Order order=new Order(Instant.now(),orderForm.getCurrency(),shippingDetails,trackingDetails);
        orderForm.getOrderItemList().forEach(item -> order.addItem(item.getProduct(), item.getQuantity()));
        return order;
    }
}
