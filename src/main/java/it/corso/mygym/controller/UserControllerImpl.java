package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private UserService userService;

    public UserControllerImpl(final UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {

        User userSaved = userService.save(userDto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> findById(@PathVariable(value="id") Long id) {
        User user = userService.findById(id).get();

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<User>> delete(Long id) {
        userService.delete(id);
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }
}
