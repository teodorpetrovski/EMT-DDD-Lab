package mk.ukim.finki.emt.sales.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.location.Address;
import mk.ukim.finki.emt.sharedkernel.domain.location.ZIPCode;

import javax.validation.constraints.NotNull;

@Data
public class ShippingDetailsForm {

    @NotNull
    private Address address;
    @NotNull
    private ZIPCode zipCode;
}
