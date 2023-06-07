package com.example.mma_fightera.Service;

import com.example.mma_fightera.Model.Flyweight_female;
import com.example.mma_fightera.Repository.Flyweight_female_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Flyweight_female_Service {
    @Autowired
    Flyweight_female_Repo ffr;

    public List<Flyweight_female> fetchAll() {
        return ffr.fetchAll();
    }

    public void addFighter(Flyweight_female FWF) {
        ffr.addFighter(FWF);
    }

    public Flyweight_female FWF_ID(int id) {
        return ffr.FWF_ID(id);
    }

    public boolean delete(int id) {
        return ffr.delete(id);
    }

    public void updateF(int id, Flyweight_female FWFO) {
        ffr.updateF(id, FWFO);
    }
}
