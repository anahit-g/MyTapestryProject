package com.example.myTapestry.services.myServices.impl;

import com.example.myTapestry.entities.User;
import com.example.myTapestry.services.myServices.IAuthService;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;

/**
 * Created by anahitg on 4/20/16.
 */
public class AuthServiceImpl implements IAuthService {

    public static final String USER_KEY = "user";

    @Inject
    private Request request;

    @Override
    public User getLoggedUser() {
        User user = null;
        if (isLoggedIn()) {
            user = (User) request.getSession(true).getAttribute(USER_KEY);
        }
        return user;
    }

    @Override
    public boolean isLoggedIn() {
        Session session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(USER_KEY) != null;
        }
        return false;
    }

    @Override
    public void logout() {
        Session session = request.getSession(false);
        if (session != null) {
            session.setAttribute(USER_KEY, null);
            session.invalidate();
        }
    }
}
