package mk.ukim.finki.emt.sales.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Brand implements ValueObject {

    private final BrandId brandId;
    private final String name;

    @JsonCreator
    public Brand(@JsonProperty("id") BrandId brandId, String name)
    {
        this.brandId=brandId;
        this.name=name;
    }
}
