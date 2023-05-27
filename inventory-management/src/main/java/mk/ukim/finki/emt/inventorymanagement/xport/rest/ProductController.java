package mk.ukim.finki.emt.inventorymanagement.xport.rest;

import mk.ukim.finki.emt.inventorymanagement.domain.models.Product;
import mk.ukim.finki.emt.inventorymanagement.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll()
    {
        return this.productService.getAll();
    }
}
