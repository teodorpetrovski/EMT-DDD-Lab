package mk.ukim.finki.emt.sales.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Category implements ValueObject {

    private final CategoryId categoryId;
    private final String name;

    @JsonCreator
    public Category(@JsonProperty("id") CategoryId categoryId,String name)
    {
        this.categoryId=categoryId;
        this.name=name;
    }
}
