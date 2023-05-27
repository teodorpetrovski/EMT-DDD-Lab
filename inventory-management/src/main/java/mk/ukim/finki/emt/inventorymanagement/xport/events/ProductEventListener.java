package mk.ukim.finki.emt.inventorymanagement.xport.events;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.inventorymanagement.domain.models.ProductId;
import mk.ukim.finki.emt.inventorymanagement.services.ProductService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductEventListener {

    private final ProductService productService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            productService.itemOrdered(ProductId.of(event.getProductId()), Quantity.of(event.getQuantity()));
        } catch (Exception e) {

        }

    }
}