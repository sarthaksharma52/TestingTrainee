package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Traine;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ITraineRepo;

@Service
public class ITraineServiceImpl implements ITraineService {

    @Autowired
    private ITraineRepo repo;

    @Override
    public List<Traine> getAllTrainees() {
        return repo.findAll();
    }

    @Override
    public Traine getTraineeById(int id) {
        try {
        	return repo.findById(id)
        		    .orElseThrow(() -> new ResourceNotFoundException("Trainee not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Trainee not found with id: " + id);
        }
    }

    @Override
    public List<Traine> getTraineeByName(String name) {
        return repo.findByTraineeNameIgnoreCase(name);
    }

    @Override
    public Traine addTrainee(Traine trainee) {
        return repo.save(trainee);
    }

    @Override
    public Traine updateTrainee(int id, Traine trainee) {
        Traine existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainee not found"));

        existing.setTraineeName(trainee.getTraineeName());
        existing.setTraineeDomain(trainee.getTraineeDomain());
        existing.setTraineeLocation(trainee.getTraineeLocation());

        return repo.save(existing);
    }

    @Override
    public void deleteTrainee(int id) {
        repo.deleteById(id);
    }
}