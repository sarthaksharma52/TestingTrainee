package com.example.demo.service;

import java.util.List;
import com.example.demo.entities.Traine;

public interface ITraineService {

    List<Traine> getAllTrainees();
    Traine getTraineeById(int id);
    List<Traine> getTraineeByName(String traineeName);
    Traine addTrainee(Traine trainee);
    Traine updateTrainee(int id, Traine trainee);
    void deleteTrainee(int id);
}