package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(Long id);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(Long id);

    User findByUsername(String username);
}
