package mk.ukim.finki.emt.inventorymanagement.services.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.inventorymanagement.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.inventorymanagement.domain.models.Brand;
import mk.ukim.finki.emt.inventorymanagement.domain.models.Category;
import mk.ukim.finki.emt.inventorymanagement.domain.models.Product;
import mk.ukim.finki.emt.inventorymanagement.domain.models.ProductId;
import mk.ukim.finki.emt.inventorymanagement.domain.repository.ProductRepository;
import mk.ukim.finki.emt.inventorymanagement.services.ProductService;
import mk.ukim.finki.emt.inventorymanagement.services.forms.ProductForm;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findById(ProductId productId) {
        return this.productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product createProduct(ProductForm productForm) {
        Brand brand=new Brand(productForm.getBrand().getName());
        Category category=new Category(productForm.getCategory().getName());
        Product product=Product.build(productForm.getProductName(), productForm.getProductDescription(), productForm.getProductPrice(),
                productForm.getQuantity(),productForm.getAvailableSizes(),productForm.getAvailableColors(),brand,category);
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product itemOrdered(ProductId productId, Quantity quantity) {
        Product product=this.findById(productId);
        product.removeQuantity(quantity);
        this.productRepository.saveAndFlush(product);
        return product;
    }

    @Override
    public Product itemRemovedFromOrder(ProductId productId, Quantity quantity) {
        Product product=this.findById(productId);
        product.addQuantity(quantity);
        this.productRepository.saveAndFlush(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
