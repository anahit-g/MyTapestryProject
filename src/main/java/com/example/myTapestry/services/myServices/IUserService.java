package com.example.myTapestry.services.myServices;

import com.example.myTapestry.entities.User;

import java.util.List;

/**
 * Created by anahitg on 4/19/16.
 */
public interface IUserService {

    public User getUserById(long id);

    public List<User> getUsers();

    public void addUser(User user);

    public void deleteUser(long id);

    public User updateUser(User user);

}
