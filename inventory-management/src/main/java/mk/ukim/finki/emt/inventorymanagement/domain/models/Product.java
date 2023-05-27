package mk.ukim.finki.emt.inventorymanagement.domain.models;

import jakarta.persistence.*;
import mk.ukim.finki.emt.inventorymanagement.domain.enums.Color;
import mk.ukim.finki.emt.inventorymanagement.domain.enums.Size;
import mk.ukim.finki.emt.sharedkernel.domain.metrics.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.finance.Money;

import java.util.List;


@Entity
@Table(name = "product")
public class Product extends AbstractEntity<ProductId> {

    private String productName;
    private String productDescription;


    @AttributeOverrides({
            @AttributeOverride(name="currency",column= @Column(name = "price_currency")),
            @AttributeOverride(name="amount",column=@Column(name = "price_amount"))
    })
    private Money productPrice;
    private Quantity quantity;
    private List<Size> availableSizes;
    private List<Color> availableColors;

    @OneToOne
    private Brand brand;

    @OneToOne
    private Category category;

    public Product() {
        super(ProductId.randomId(ProductId.class));
    }

    public static Product build(String productName,String productDescription,Money productPrice,Quantity quantity, List<Size> availableSizes,List<Color> availableColors,Brand brand,Category category)
    {
        Product p=new Product();
        p.productName=productName;
        p.productDescription=productDescription;
        p.productPrice=productPrice;
        p.quantity=quantity;
        p.availableSizes=availableSizes;
        p.availableColors=availableColors;
        p.brand=brand;
        p.category=category;
        return p;
    }

    public void addQuantity(Quantity quantity)
    {
        this.quantity=this.quantity.sum(quantity);
    }

    public void removeQuantity(Quantity quantity)
    {
        this.quantity=this.quantity.subtract(quantity);
    }




}
