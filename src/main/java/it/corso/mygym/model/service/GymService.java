package it.corso.mygym.model.service;

import it.corso.mygym.model.Gym;
import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.GymDto;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.repository.GymRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface GymService{
    Gym save(GymDto gymDto);
    Optional<Gym> findById(Long id);
    List<Gym> findAll();
    void delete(Long id);
    Gym update(Long id, GymDto GymDto);
}

// import spring data rest for throw exception