package ru.kata.spring.boot_security.demo.Dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u")
                .getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }


    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id =:id", User.class)
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username =:username",
                User.class).getSingleResult();
    }
}
