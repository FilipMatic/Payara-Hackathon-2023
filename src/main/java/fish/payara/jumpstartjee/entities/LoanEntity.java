package fish.payara.jumpstartjee.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class LoanEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanId;

    @NotNull
    private Long clientId;

    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate loanDate;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private BigDecimal amountOwed;

    @NotNull
    private BigDecimal interestRate;
}
