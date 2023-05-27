package mk.ukim.finki.emt.inventorymanagement.services;

import mk.ukim.finki.emt.inventorymanagement.domain.models.Product;
import mk.ukim.finki.emt.inventorymanagement.domain.models.ProductId;
import mk.ukim.finki.emt.inventorymanagement.services.forms.ProductForm;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;

import java.util.List;

public interface ProductService {

    Product findById(ProductId productId);
    Product createProduct(ProductForm productForm);
    Product itemOrdered(ProductId productId, Quantity quantity);
    Product itemRemovedFromOrder(ProductId productId,Quantity quantity);
    List<Product> getAll();
}
