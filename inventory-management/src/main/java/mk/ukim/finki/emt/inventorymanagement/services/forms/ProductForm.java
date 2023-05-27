package mk.ukim.finki.emt.inventorymanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.inventorymanagement.domain.enums.Color;
import mk.ukim.finki.emt.inventorymanagement.domain.enums.Size;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductForm {

    @NotEmpty
    private String productName;
    @NotEmpty
    private String productDescription;

    @NotNull
    private Money productPrice;
    @NotNull
    private Quantity quantity;
    private List<Size> availableSizes;
    private List<Color> availableColors;

    @NotNull
    private BrandForm brand;

    @NotNull
    private CategoryForm category;

}
