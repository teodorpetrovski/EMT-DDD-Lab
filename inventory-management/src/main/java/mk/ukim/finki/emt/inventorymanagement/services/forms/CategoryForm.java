package mk.ukim.finki.emt.inventorymanagement.services.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryForm {
    @NotEmpty
    private String name;
}
