package mk.ukim.finki.emt.customerrelationshipmanagement.services.forms;

import jakarta.persistence.Embeddable;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReviewForm {
    @NotNull
    private Double rating;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

}
