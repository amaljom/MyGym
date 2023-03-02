package it.corso.mygym.model.service;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {

//    @Autowired
//    UserRepo userRepo;

    User save(UserDto userDto);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(Long id);
    User update(Long id, UserDto userDto);


}
