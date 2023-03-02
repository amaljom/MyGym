package it.corso.mygym.model.repository;

import it.corso.mygym.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    // TODO: find by paid=true
    List<Subscription> findByIsPayedTrue();


    // TODO: find by active subscription
    // @Query(value= "select * from subscription WHERE ")
    List<Subscription> findByEndDateBefore(LocalDate currentDate);
}
