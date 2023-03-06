package fish.payara.jumpstartjee.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Client")
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @JsonbDateFormat("dd.MM.yyyy")
    @NotNull
    @Past
    @Column(name = "birth_date")
    private LocalDate birthdate;

    @JsonbDateFormat("dd.MM.yyyy")
    @NotNull
    @PastOrPresent
    @Column(name = "join_date")
    private LocalDate joinDate;
}
