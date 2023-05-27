package mk.ukim.finki.emt.sales.domain.models;

import jakarta.persistence.Entity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
public class TrackingDetails extends AbstractEntity<TrackingDetailsId> {

   private String courierName;
   private String trackingNumber;

   public TrackingDetails()
   {
       super(TrackingDetailsId.randomId(TrackingDetailsId.class));
   }

    public TrackingDetails(String courierName, String trackingNumber) {
        super(TrackingDetailsId.randomId(TrackingDetailsId.class));
        this.courierName = courierName;
        this.trackingNumber = trackingNumber;
    }
}
