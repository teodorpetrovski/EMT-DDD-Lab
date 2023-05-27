package mk.ukim.finki.emt.customerrelationshipmanagement.domain.models;

import jakarta.persistence.Entity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.time.Instant;

@Entity
public class Review extends AbstractEntity<ReviewId> {
   private Double rating;
   private String title;
   private String content;
   private Instant createdAt;



    public Review(Double rating, String title, String content, Instant createdAt) {
        super(ReviewId.randomId(ReviewId.class));
        this.rating = rating;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
