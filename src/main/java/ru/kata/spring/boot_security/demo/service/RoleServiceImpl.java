package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.Dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void editRole(Role role) {
        roleDao.editRole(role);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return roleDao.listByName(name);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
