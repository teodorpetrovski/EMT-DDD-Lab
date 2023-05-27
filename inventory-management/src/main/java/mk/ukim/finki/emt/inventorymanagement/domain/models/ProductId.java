package mk.ukim.finki.emt.inventorymanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ProductId extends DomainObjectId {

    public ProductId(@NonNull String uuid) {
        super(uuid);
    }

    public static ProductId of(String uuid) {
        ProductId p = new ProductId(uuid);
        return p;
    }

}
