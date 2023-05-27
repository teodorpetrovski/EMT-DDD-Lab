package mk.ukim.finki.emt.sales.domain.models;

import jakarta.persistence.Entity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.location.Address;
import mk.ukim.finki.emt.sharedkernel.domain.location.ZIPCode;

@Entity
public class ShippingDetails extends AbstractEntity<ShippingDetailsId> {
   private Address address;
   private ZIPCode zipCode;

   public ShippingDetails()
   {
       super(ShippingDetailsId.randomId(ShippingDetailsId.class));
   }

    public ShippingDetails(Address address, ZIPCode zipCode) {
        super(ShippingDetailsId.randomId(ShippingDetailsId.class));
        this.address = address;
        this.zipCode = zipCode;
    }
}
