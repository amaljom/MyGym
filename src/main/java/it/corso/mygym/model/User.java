package it.corso.mygym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;

    private String surname;

    private String email;

    @Nullable
    private LocalDate dateOfBirth;
    @Nullable
    private Boolean certification;

    @NotNull
    private Boolean activated = true;
    @NotNull
    private Boolean activateFlag = true;


    @OneToMany(mappedBy = "user")
    List<Subscription> subscriptions;


}
