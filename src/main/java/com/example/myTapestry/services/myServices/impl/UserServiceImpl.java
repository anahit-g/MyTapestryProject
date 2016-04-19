package com.example.myTapestry.services.myServices.impl;

import com.example.myTapestry.entities.User;
import com.example.myTapestry.services.myServices.IUserService;
import org.hibernate.Session;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by anahitg on 4/19/16.
 */
public class UserServiceImpl implements IUserService {  /* bind it in AppModule */

    @Inject
    private Session session;

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return session.createCriteria(User.class).list();
    }

    @Override
    public void addUser(User user) {
        session.save(user);
    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
