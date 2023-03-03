package it.corso.mygym.model.service;

import it.corso.mygym.Constants;
import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.excpetion.UserNotFoundException;
import it.corso.mygym.model.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo repo;
    @Override
    public User save(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();

        return repo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public Optional<User> findById(Long id) {
        validateExists(id); // throws error if not existing
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        validateExists(id);
        //usare il metodo per vedere se esiste
        Optional<User> user = repo.findById(id);
        User userToDelete = user.get();
        repo.delete(userToDelete);
    }
    @Override
    public User update(Long id, UserDto userDto) {
        validateExists(id);

        User userOld = repo.findById(id).get();
        userDto.setId(id);
        BeanUtils.copyProperties(userDto, userOld);

        return repo.saveAndFlush(userOld);
    }

    private void validateExists(Long id){
        if (repo.findById(id).isEmpty()) throw new UserNotFoundException(Constants.USER_NOT_FOUND_EXCEPTION, id);
    }


}
