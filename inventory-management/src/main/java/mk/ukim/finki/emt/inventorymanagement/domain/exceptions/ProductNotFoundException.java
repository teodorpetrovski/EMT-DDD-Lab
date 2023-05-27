package mk.ukim.finki.emt.inventorymanagement.domain.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super("Product not found!");
    }
}
