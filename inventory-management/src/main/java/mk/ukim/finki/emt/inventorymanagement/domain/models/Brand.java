package mk.ukim.finki.emt.inventorymanagement.domain.models;

import jakarta.persistence.Entity;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;


@Entity
public class Brand extends AbstractEntity<BrandId> {


    private String name;

    public Brand(@NonNull String name) {
        super(BrandId.randomId(BrandId.class));
        this.name=name;
    }


    public Brand() {
        super(BrandId.randomId(BrandId.class));
    }
}
