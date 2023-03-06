package fish.payara.jumpstartjee.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class ReportEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;

    @NotNull
    private Long clientId;

    @NotNull
    private Long accountId;

    @JsonbDateFormat("yyyy-MM-dd")
    @NotNull
    private LocalDate month;

    @NotNull
    private List<Long> transactionIds;
}
