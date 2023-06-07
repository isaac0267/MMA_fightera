package com.example.mma_fightera.Repository;

import com.example.mma_fightera.Model.Flyweight_male;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Flyweight_male_Repo {
    @Autowired
    JdbcTemplate template;


    // The method that will print the whole tabel.
    public List<Flyweight_male> fetchAll() {
        String sql = "SELECT* FROM flyweight_male";
        RowMapper<Flyweight_male> rowMapper = new BeanPropertyRowMapper<>(Flyweight_male.class);
        return template.query(sql, rowMapper);
    }

    // A method that will add the new Flyweight_male_fighter
    public void FWM_add(Flyweight_male FWM) {
        String sql = "INSERT INTO flyweight_male(first_name, last_name,lose,win,weight) VALUES(?,?,?,?,?)";
        template.update(sql, FWM.getFirst_name(),
                FWM.getLast_name(),
                FWM.getLose(),
                FWM.getWin(),
                FWM.getWeight());
    }

    // This the method that will view the fighter from FWM tabel.
    public Flyweight_male fWM_View(int id) {
        String sql = "SELECT* FROM flyweight_male WHERE id=?";
        RowMapper<Flyweight_male> rowMapper = new BeanPropertyRowMapper<>(Flyweight_male.class);
        Flyweight_male FWMOb = template.queryForObject(sql, rowMapper, id);
        return FWMOb;
    }
    // This method will delete a FWM from the tabel.

    public boolean delete(int id) {
        String sql = "DELETE FROM flyweight_male WHERE id=?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Flyweight_male FWMB) {
        String sql = "UPDATE flyweight_male SET first_name=?, last_name=?,lose=?,win=?,weight=?WHERE id=?";
        template.update(sql, FWMB.getFirst_name(),
                FWMB.getLast_name(),
                FWMB.getLose(),
                FWMB.getWin(),
                FWMB.getWeight(),
                FWMB.getId());
    }


}
