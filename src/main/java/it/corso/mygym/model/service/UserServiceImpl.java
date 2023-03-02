package it.corso.mygym.model.service;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        return repo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = repo.findById(id);
        if(user.isPresent()){
            User userToDelete = user.get();
            repo.delete(userToDelete);
        }else throw new ResourceNotFoundException();
    }
    @Override
    public User update(Long id, UserDto userDto) {
        Optional<User> userOld = repo.findById(id);

        if(userOld.isPresent()){
            userDto.setId(id);
            BeanUtils.copyProperties(userDto, userOld);
            return repo.saveAndFlush(userOld.get());
        }else throw new ResourceNotFoundException();

    }




}
