package it.corso.mygym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="gym")
public class Gym implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;

    private String pIva;

    @OneToMany(mappedBy = "gym")
    List<Subscription> subscriptions;



}
