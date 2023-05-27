package mk.ukim.finki.emt.sales.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Currency;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class OrderForm {

    @NotEmpty
    private Set<OrderItemForm> orderItemList;


    @NotNull
    private ShippingDetailsForm shippingDetails;


    @NotNull
    private TrackingDetailsForm trackingDetails;

    @NotNull
    private Currency currency;
}
