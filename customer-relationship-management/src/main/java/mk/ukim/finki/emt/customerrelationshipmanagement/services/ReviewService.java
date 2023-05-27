package mk.ukim.finki.emt.customerrelationshipmanagement.services;

import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.Review;
import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.ReviewId;
import mk.ukim.finki.emt.customerrelationshipmanagement.services.forms.ReviewForm;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findById(ReviewId reviewId);

    Review addReview(ReviewForm reviewForm);
    Review addReview(Double rating,String title,String content);

    List<Review> getAll();
}
