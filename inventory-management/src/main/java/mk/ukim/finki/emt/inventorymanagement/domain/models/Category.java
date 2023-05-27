package mk.ukim.finki.emt.inventorymanagement.domain.models;

import jakarta.persistence.Entity;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
public class Category extends AbstractEntity<CategoryId> {

    private String name;

    public Category(@NonNull String name) {
        super(CategoryId.randomId(CategoryId.class));
        this.name=name;
    }


    public Category() {
        super(CategoryId.randomId(CategoryId.class));
    }
}
