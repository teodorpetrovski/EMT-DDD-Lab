package mk.ukim.finki.emt.sharedkernel.domain.location;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String city;
    private final String street;
    private final String homeNumber;

    protected Address()
    {
        this.city = "";
        this.street = "";
        this.homeNumber = "";
    }

    public Address(@NonNull String city,@NonNull String street,@NonNull String homeNumber) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
    }

    public static Address valueOf(String city,String street,String homeNumber)
    {
        return new Address(city,street,homeNumber);
    }

    public boolean validate()
    {
        String streetPattern = "^[a-zA-Z\\s]+$";
        String numberPattern = "^[0-9]{3}$";

        return street.matches(streetPattern) && homeNumber.matches(numberPattern);
    }
}
