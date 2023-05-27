package mk.ukim.finki.emt.sharedkernel.domain.location;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;


@Embeddable
@Getter
public class ZIPCode implements ValueObject {

    private final String code;

    protected ZIPCode()
    {
        this.code="";
    }

    public ZIPCode(@NonNull String code)
    {
        this.code=code;
    }

    public static ZIPCode valueOf(String code)
    {
        return new ZIPCode(code);
    }


    public boolean validate()
    {
        if(code.length()!=4)
            return false;
        if(code.matches("[0-9]+"))
            return true;
        return false;
    }


}
