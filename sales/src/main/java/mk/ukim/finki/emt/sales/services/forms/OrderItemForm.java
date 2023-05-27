package mk.ukim.finki.emt.sales.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sales.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {
    @NotNull
    private Money productPrice;

    @NotNull
    private Product product;
    @Min(1)
    private int quantity;
}
