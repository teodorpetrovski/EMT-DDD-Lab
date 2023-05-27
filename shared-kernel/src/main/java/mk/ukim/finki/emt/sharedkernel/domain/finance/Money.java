package mk.ukim.finki.emt.sharedkernel.domain.finance;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value=EnumType.STRING)
    private final Currency currency;
    private final double amount;

    protected Money() {
        this.currency=null;
        this.amount=0.0;
    }

    public Money(@NonNull Currency currency,@NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }


    public static Money valueOf(Currency currency,double amount)
    {
        return new Money(currency,amount);
    }

    public Money sum(Money money){
        if(!currency.equals(money.currency))
            throw new IllegalArgumentException("Cant add up different currencies");
        return new Money(currency,amount+money.amount);
    }

    public Money subtract(Money money){
        if(!currency.equals(money.currency))
            throw new IllegalArgumentException("Cant subtract up different currencies");
        return new Money(currency,amount-money.amount);
    }

    public Money multiply(int times)
    {
        return new Money(currency,amount*times);
    }

    public Money convertTo(Currency currency)
    {
        if(currency ==Currency.EUR && this.currency==Currency.MKD)
            return new Money(Currency.EUR,this.amount/61);
        if(currency ==Currency.MKD && this.currency==Currency.EUR)
            return new Money(Currency.EUR,this.amount*61);

        return new Money(this.currency,this.amount);
    }
}
