package it.corso.mygym.model.service;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;


import java.util.List;
import java.util.Optional;


public interface SubscriptionService {
    Subscription save(SubscriptionDto SubscriptionDto);
    Optional<Subscription> findById(Long id);
    List<Subscription> findAll();
    void delete(Long id);
    Subscription update(Long id, SubscriptionDto SubscriptionDto);
}
