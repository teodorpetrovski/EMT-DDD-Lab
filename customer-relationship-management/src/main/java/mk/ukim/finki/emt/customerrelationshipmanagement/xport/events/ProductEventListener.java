package mk.ukim.finki.emt.customerrelationshipmanagement.xport.events;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.customerrelationshipmanagement.services.ReviewService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductEventListener {

    private final ReviewService reviewService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            this.reviewService.addReview(5.00,"Order Review","Product " + event.getProductId()+" with quantity: "+ event.getQuantity());
        } catch (Exception e) {

        }

    }
}