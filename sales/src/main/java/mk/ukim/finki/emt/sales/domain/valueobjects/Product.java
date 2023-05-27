package mk.ukim.finki.emt.sales.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;

import java.util.List;


@Getter
public class Product implements ValueObject {

    private final ProductId productId;
    private final String productName;
    private final String productDescription;
    private final Money productPrice;
    private final Quantity quantity;
    private final List<Size> availableSizes;
    private final List<Color> availableColors;

    private final Brand brand;

    private final Category category;

    @JsonCreator
    public Product(@JsonProperty("id") ProductId productId, String productName, String productDescription, Money productPrice, Quantity quantity, List<Size> availableSizes, List<Color> availableColors, Brand brand, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.availableSizes = availableSizes;
        this.availableColors = availableColors;
        this.brand = brand;
        this.category = category;
    }
}
