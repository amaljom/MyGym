package it.corso.mygym.model;

import it.corso.mygym.model.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private String type;

    private LocalDate startDate;

    private LocalDate endDate;

    private int price;
    @NonNull
    private Boolean isPayed;

    @ManyToOne
    @JoinColumn(name= "gym_id")
    Gym gym;

    @ManyToOne
    @JoinColumn(name= "user_id")
    User user;

    @Column(name="type")
    private Type type;
}

