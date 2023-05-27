package mk.ukim.finki.emt.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }



}
