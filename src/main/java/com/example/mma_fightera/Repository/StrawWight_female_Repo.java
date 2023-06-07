package com.example.mma_fightera.Repository;

import com.example.mma_fightera.Model.StrawWight_female;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.util.List;

@Repository
public class StrawWight_female_Repo {
    // It is very important to write this annotation. Otherwise, it will make the error.
    @Autowired
    JdbcTemplate template;

    // This method will print the whole table, beacuse we are saying that print the whole
    public List<StrawWight_female> fetchAll() {
        String sql = "SELECT* FROM strawweight_female";
        RowMapper<StrawWight_female> rowMapper = new BeanPropertyRowMapper<>(StrawWight_female.class);
        return template.query(sql, rowMapper);
    }

    // a method that will add to the table that we have in MySQL.
    public void add_Starwwight(StrawWight_female strawWight_female) {
        String sql = "INSERT INTO strawweight_female(first_name, last_name,lose,win,weight) VALUES(?,?,?,?,?)";
        template.update(sql, strawWight_female.getFirst_name(), strawWight_female.getLast_name(),
                strawWight_female.getLose(), strawWight_female.getWin(), strawWight_female.getWeight());
    }
    // A method that will finde the person by the ID.
    // In this method I will use the RowMapper.
    public StrawWight_female findeByID(int id) {
        String sql = "SELECT* FROM strawweight_female WHERE id=?";
        RowMapper<StrawWight_female> rowMapper = new BeanPropertyRowMapper<>(StrawWight_female.class);
        StrawWight_female strawwight_female = template.queryForObject(sql, rowMapper, id);
        return strawwight_female;
    }
    // delete method that will delete.

    public boolean deleteFighter(int id) {
     String sql="DELETE FROM strawweight_female WHERE id=?";
     return template.update(sql,id)>0;

    }
    // The update method
    // We have to parameter in this method, we do not use the id, but we use that in the service.

    public void update(int id, StrawWight_female s) {
      String sql="UPDATE strawweight_female SET first_name=?, last_name=?, lose=?, win=?, weight=? WHERE id=?";
      template.update(sql,s.getFirst_name(),s.getLast_name(),s.getLose(),s.getWin(),s.getWeight(),s.getId());
    }

}
