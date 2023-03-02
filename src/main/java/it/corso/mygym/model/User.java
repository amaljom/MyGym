package it.corso.mygym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private LocalDate dateOfBirth;

    private Boolean certification;

    private Boolean activated;

    @OneToMany(mappedBy = "user")
    List<Subscription> subscriptions;


}
