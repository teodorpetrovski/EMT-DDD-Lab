package mk.ukim.finki.emt.sales.domain.exceptions;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException() {
        super("Order item not found!!");
    }
}
