package com.example.mma_fightera.Service;

import com.example.mma_fightera.Model.StrawWight_female;
import com.example.mma_fightera.Repository.StrawWight_female_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrawWight_female_Service {

    @Autowired
    StrawWight_female_Repo strawWight_female_repo;

    // The first method in the repo is will be return now.

    public List<StrawWight_female> fetchAll() {
        return strawWight_female_repo.fetchAll();
    }

    // the insert method.

    public void addFighter(StrawWight_female strawWight_female) {
        strawWight_female_repo.add_Starwwight(strawWight_female);
    }

    // The method that will finde the fighter.

    public StrawWight_female findeByID(int id) {
       return strawWight_female_repo.findeByID(id);
    }
     // This is the delet method.

    public boolean delete(int id) {
       return strawWight_female_repo.deleteFighter(id);
    }

    // This the update method.

    public void update(int id, StrawWight_female s) {
        strawWight_female_repo.update(id, s);
    }


}
