package mk.ukim.finki.emt.sales.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sales.domain.valueobjects.ProductId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;

@Entity
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money productPrice;
    @AttributeOverride(name="id",column = @Column(name = "product_id",nullable = false))
    private ProductId product;
    private int quantity;

    public OrderItem(Money productPrice, ProductId product, int quantity)
    {
        super(OrderItemId.randomId(OrderItemId.class));
        this.productPrice=productPrice;
        this.product=product;
        this.quantity=quantity;
    }

    public OrderItem() {
        super(OrderItemId.randomId(OrderItemId.class));
    }

    public Money subtotal()
    {
        return productPrice.multiply(quantity);
    }
}
