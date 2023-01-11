package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {

    Role getRole(int id);

    List<Role> getList();

    void deleteRole(int id);

    void editRole(Role role);

    Role findByName(String name);

    List<Role> listByName(List<String> name);

    void addRole(Role role);


}
