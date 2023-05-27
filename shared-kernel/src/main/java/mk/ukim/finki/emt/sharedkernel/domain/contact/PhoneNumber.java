package mk.ukim.finki.emt.sharedkernel.domain.contact;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class PhoneNumber implements ValueObject {

    private final String number;


    protected PhoneNumber()
    {
        number="";
    }

    public PhoneNumber(@NonNull String number)
    {
        this.number=number;
    }

    public static PhoneNumber valueOf(String number)
    {
        return new PhoneNumber(number);
    }

    public boolean validate()
    {
        if(this.number.length()!= 9)
            return false;
        if(!this.number.startsWith("07"))
            return false;
        return true;
    }
}
