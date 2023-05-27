package mk.ukim.finki.emt.customerrelationshipmanagement.services.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.Review;
import mk.ukim.finki.emt.customerrelationshipmanagement.domain.models.ReviewId;
import mk.ukim.finki.emt.customerrelationshipmanagement.domain.repository.ReviewRepository;
import mk.ukim.finki.emt.customerrelationshipmanagement.services.ReviewService;
import mk.ukim.finki.emt.customerrelationshipmanagement.services.forms.ReviewForm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;


    @Override
    public Optional<Review> findById(ReviewId reviewId) {
        return this.reviewRepository.findById(reviewId);
    }

    @Override
    public Review addReview(ReviewForm reviewForm) {
        Review review=this.toDomainObject(reviewForm);
        this.reviewRepository.saveAndFlush(review);
        return review;
    }

    @Override
    public Review addReview(Double rating, String title, String content) {
        Review review=new Review(rating,title,content,Instant.now());
        this.reviewRepository.saveAndFlush(review);
        return review;
    }

    @Override
    public List<Review> getAll() {
        return this.reviewRepository.findAll();
    }

    private Review toDomainObject(ReviewForm reviewForm)
    {
        return new Review(reviewForm.getRating(),reviewForm.getTitle(),reviewForm.getContent(),Instant.now());
    }
}
