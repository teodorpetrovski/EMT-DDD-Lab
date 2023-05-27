package mk.ukim.finki.emt.sharedkernel.domain.metrics;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Quantity implements ValueObject {
    private final int quantity;


    protected Quantity() {
        this.quantity = 0;
    }

    public static Quantity of(int quantity)
    {
        return new Quantity(quantity);
    }

    public Quantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Quantity sum(Quantity qty)
    {
        return new Quantity(this.quantity+qty.quantity);
    }

    public Quantity subtract(Quantity qty)
    {
        return new Quantity(this.quantity-qty.quantity);
    }

}
