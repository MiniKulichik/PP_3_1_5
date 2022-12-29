package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getList() {
        return entityManager.createQuery("select r from Role r",
                Role.class).getResultList();
    }

    @Override
    public void deleteRole(int id) {
        entityManager.createQuery("DELETE FROM Role r WHERE r.id =:id", Role.class)
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("select u FROM Role u WHERe u.name = :id",
                        Role.class).setParameter("id", name)
                .getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return  entityManager.createQuery("select u FROM Role u WHERe u.name in (:id)",
                        Role.class).setParameter("id", name).getResultList();
    }

    @Override
    public boolean addRole(Role role) {
        entityManager.persist(role);
        return true;
    }
}
