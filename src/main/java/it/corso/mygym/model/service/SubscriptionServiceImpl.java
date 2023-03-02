package it.corso.mygym.model.service;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;
import it.corso.mygym.model.repository.SubscriptionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SubscriptionServiceImpl implements SubscriptionService{

    @Autowired
    SubscriptionRepo repo;

    @Override
    public Subscription save(SubscriptionDto SubscriptionDto) {
        ModelMapper modelMapper = new ModelMapper();

        return repo.save(modelMapper.map(SubscriptionDto, Subscription.class));
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Subscription> sub = repo.findById(id);
        if(sub.isPresent()){
            Subscription subToDelete = sub.get();
            repo.delete(subToDelete);
        }else throw new ResourceNotFoundException();
    }

    @Override
    public Subscription update(Long id, SubscriptionDto SubscriptionDto) {
        Optional<Subscription> SubOld = repo.findById(id);

        if(SubOld.isPresent()){
            SubscriptionDto.setId(id);
            BeanUtils.copyProperties(SubscriptionDto, SubOld);
            return repo.saveAndFlush(SubOld.get());
        }else throw new ResourceNotFoundException();
    }
}
