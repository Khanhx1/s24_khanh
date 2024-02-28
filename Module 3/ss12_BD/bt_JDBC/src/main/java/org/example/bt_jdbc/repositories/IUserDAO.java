package org.example.bt_jdbc.repositories;

import org.example.bt_jdbc.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    List<User> orderByName(String orderOption) throws SQLException;

    List<User> search(String search);
}
