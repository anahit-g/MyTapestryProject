package com.example.myTapestry.services.myServices;

import com.example.myTapestry.entities.User;

/**
 * Created by anahitg on 4/20/16.
 */
public interface IAuthService {

    User getLoggedUser();

    boolean isLoggedIn();

    void logout();

}
