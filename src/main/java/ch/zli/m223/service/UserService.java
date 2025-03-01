package ch.zli.m223.service;

import ch.zli.m223.model.User;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;


    public List<User> listAll() {
        var query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public User update(Long id, User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void delete(Long id) {
        User entity = entityManager.find(User.class, id);
        entityManager.remove(entity);
    }

}
