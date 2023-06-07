package com.example.mma_fightera.Repository;

import com.example.mma_fightera.Model.Flyweight_female;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Flyweight_female_Repo {
    @Autowired
    JdbcTemplate template;

    public List<Flyweight_female> fetchAll() {
        String sql = "SELECT* FROM flyweight_female";
        RowMapper<Flyweight_female> rowMapper = new BeanPropertyRowMapper<>(Flyweight_female.class);
        return template.query(sql, rowMapper);
    }

    // a method that will add a new fighter to the list
    public void addFighter(Flyweight_female FWF) {
        String sql = "INSERT INTO flyweight_female (first_name, last_name, lose, win,weight)VALUES(?,?,?,?,?)";
        template.update(sql, FWF.getFirst_name(),
                FWF.getLast_name(),
                FWF.getLose(),
                FWF.getWin(),
                FWF.getWeight());
    }

    // Method that will show the fighter ID
    public Flyweight_female FWF_ID(int id) {
        String sql = "SELECT* FROM flyweight_female WHERE id=?";
        RowMapper<Flyweight_female> rowMapper = new BeanPropertyRowMapper<>(Flyweight_female.class);
        Flyweight_female FWFObj = template.queryForObject(sql, rowMapper, id);
        return FWFObj;
    }
    // A method that will delete the fighter

    public boolean delete(int id) {
        String sql = "DELETE FROM flyweight_female WHERE id=?";
        return template.update(sql, id) > 0;
    }

    public void updateF(int id, Flyweight_female FWFO) {
        String sql = "UPDATE flyweight_female SET first_name=?,last_name=?,lose=?,win=?,weight=? WHERE id=?";
        template.update(sql, FWFO.getFirst_name(),
                FWFO.getLast_name(),
                FWFO.getLose(),
                FWFO.getWin(),
                FWFO.getWeight(),
                FWFO.getId());
    }


}
