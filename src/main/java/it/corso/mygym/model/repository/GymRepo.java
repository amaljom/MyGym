package it.corso.mygym.model.repository;

import it.corso.mygym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepo extends JpaRepository<Gym,Long> {

}
