package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.excpetion.UserNotFoundException;
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
    public ResponseEntity<User> findById(@PathVariable(value="id") Long id) throws UserNotFoundException {
        User user = userService.findById(id).get();

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @Override
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws UserNotFoundException{
        userService.delete(id);
        List<User> users = userService.findAll();
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(value="id")Long id, @Valid @RequestBody UserDto userDto) throws UserNotFoundException{

        User userUpdated = userService.update(id, userDto);
        return ResponseEntity.ok(userUpdated);
    }

    @ExceptionHandler({UserNotFoundException.class})
    private ResponseEntity<?> userNotFound(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
