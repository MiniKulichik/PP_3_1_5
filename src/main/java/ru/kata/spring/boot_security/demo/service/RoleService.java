package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    Role getRole(Long id);

    List<Role> getList();

    void deleteRole(Long id);

    void editRole(Role role);

    List<Role> listByName(List<String> name);

    void addRole(Role role);
}
