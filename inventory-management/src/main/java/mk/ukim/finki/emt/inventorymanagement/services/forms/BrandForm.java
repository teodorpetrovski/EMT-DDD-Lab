package mk.ukim.finki.emt.inventorymanagement.services.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BrandForm {

    @NotEmpty
    private String name;
}
