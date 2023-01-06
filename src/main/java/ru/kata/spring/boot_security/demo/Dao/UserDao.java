package ru.kata.spring.boot_security.demo.Dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(int id);

    User findByUsername(String username);
}
