package fish.payara.jumpstartjee.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Account")
public class AccountEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    private Long accountId;

    @JsonbDateFormat("dd.MM.yyyy")
    @NotNull
    @PastOrPresent
    @Column(name = "opened_date")
    private LocalDate openedDate;

    @JsonbDateFormat("dd.MM.yyyy")
    @NotNull
    @Column(name = "closed_date")
    private LocalDate closedDate;
    
    @NotNull
    @Column(name = "client_id")
    // Foreign key
    private Long clientId;

    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull
    @Column(name = "amountOwed")
    private BigDecimal amountOwed;
}
