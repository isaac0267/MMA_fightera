package com.example.mma_fightera.Service;

import com.example.mma_fightera.Model.Flyweight_male;
import com.example.mma_fightera.Repository.Flyweight_male_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Flyweight_male_Service {
    @Autowired
    Flyweight_male_Repo FWMRepo;

    public List<Flyweight_male> fetchAll() {
        return FWMRepo.fetchAll();
    }

    public void addFWM(Flyweight_male FWMOb) {
        FWMRepo.FWM_add(FWMOb);
    }

    public Flyweight_male fWM_View(int id) {
        return FWMRepo.fWM_View(id);
    }

    public boolean delete(int id) {
        return FWMRepo.delete(id);
    }

    public void update(int id, Flyweight_male FWMB) {
        FWMRepo.update(id, FWMB);
    }
}
