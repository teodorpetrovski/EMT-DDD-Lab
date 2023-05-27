package mk.ukim.finki.emt.sharedkernel.domain.contact;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import java.util.regex.Pattern;


@Embeddable
@Getter
public class Email implements ValueObject {

    private final String email;

    protected Email()
    {
        this.email="";
    }

    public Email(@NonNull String email)
    {
        this.email=email;
    }

    public static Email valueOf(String email)
    {
        return new Email(email);
    }

    public boolean validate() {
        String regexPattern="^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }



}
