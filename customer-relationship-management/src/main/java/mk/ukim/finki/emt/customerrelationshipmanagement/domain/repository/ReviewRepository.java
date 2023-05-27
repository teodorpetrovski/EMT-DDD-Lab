package mk.ukim.finki.emt.customerrelationshipmanagement.domain.repository;

import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.Review;
import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
}
