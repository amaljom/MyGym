package it.corso.mygym.model.service;

import it.corso.mygym.model.Gym;
import it.corso.mygym.model.dto.GymDto;
import it.corso.mygym.model.repository.GymRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GymServiceImpl implements GymService{

    @Autowired
    GymRepo repo;


    @Override
    public Gym save(GymDto gymDto) {
        ModelMapper modelMapper = new ModelMapper();

        return repo.save(modelMapper.map(gymDto, Gym.class));
    }

    @Override
    public Optional<Gym> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Gym> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Gym> gym = repo.findById(id);
        if(gym.isPresent()){
            Gym gymToDelete = gym.get();
            repo.delete(gymToDelete);
        }else throw new ResourceNotFoundException();
    }

    @Override
    public Gym update(Long id, GymDto GymDto) {
        Optional<Gym> gymOld = repo.findById(id);

        if(gymOld.isPresent()){
            GymDto.setId(id);
            BeanUtils.copyProperties(GymDto, gymOld);
            return repo.saveAndFlush(gymOld.get());
        }else throw new ResourceNotFoundException();
    }
}
