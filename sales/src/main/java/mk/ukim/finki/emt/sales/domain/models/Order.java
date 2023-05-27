package mk.ukim.finki.emt.sales.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sales.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant orderDateAndTime;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private Set<OrderItem> orderItemList = new HashSet<>();

    @OneToOne
    private ShippingDetails shippingDetails;

    @OneToOne
    private TrackingDetails trackingDetails;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    public Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant orderDateAndTime,Currency currency, ShippingDetails shippingDetails,TrackingDetails trackingDetails)
    {
        super(OrderId.randomId(OrderId.class));
        this.orderDateAndTime=orderDateAndTime;
        this.currency=currency;
        this.shippingDetails=shippingDetails;
        this.trackingDetails=trackingDetails;
    }



    public Money total()
    {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency,0),Money::sum);
    }

    public OrderItem addItem(@NonNull Product product, int quantity)
    {
        Objects.requireNonNull(product,"Product must be not null");
        var orderItem=new OrderItem(product.getProductPrice(),product.getProductId(),quantity);
        orderItemList.add(orderItem);
        return orderItem;
    }

    public void removeItem(@NonNull OrderItemId ItemId)
    {
        Objects.requireNonNull(ItemId,"OrderItem must be not null");
       orderItemList.removeIf(v -> v.getId().equals(ItemId));
    }

}
