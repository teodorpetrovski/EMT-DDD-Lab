package mk.ukim.finki.emt.sales.domain.exceptions;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException() {
        super("Order not found!");
    }
}
