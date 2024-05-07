package ru.gb.my_first_crud.repository;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.my_first_crud.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {


    private JdbcTemplate jdbc;


    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
    public void updateUser(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
    public User findById(int id) {
        String sql = "SELECT * FROM userTable WHERE id = " + id;
        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });
        List<User> users = jdbc.query(sql, userRowMapper);
        if (users.isEmpty()) {
            return null;
        } else {
            return jdbc.query(sql, userRowMapper).get(0);
        }
    }
}