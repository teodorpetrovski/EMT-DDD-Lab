package mk.ukim.finki.emt.sales.services.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TrackingDetailsForm {

    @NotEmpty
    private String courierName;
    @NotEmpty
    private String trackingNumber;
}
