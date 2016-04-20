package com.example.myTapestry.pages;

import com.example.myTapestry.entities.User;
import com.example.myTapestry.services.myServices.IUserService;
import com.example.myTapestry.utility.Util;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

/**
 * Created by anahitg on 4/14/16.
 */
public class Registration {

    @Inject
    private IUserService userService;

    @Inject
    private Logger logger;

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form registration;

    @InjectComponent("name")
    private TextField nameField;

    @InjectComponent("surname")
    private TextField surnameField;

    @InjectComponent("email")
    private TextField emailField;

    @InjectComponent("password")
    private PasswordField passwordField;

    @Property
    private String name;

    @Property
    private String surname;

    @Property
    private String email;

    @Property
    private String password;

    void onValidateFromRegistration() {

        if ( name.isEmpty() )
            registration.recordError(nameField, "Name is required");

        if ( surname.isEmpty() )
            registration.recordError(surnameField, "Surname is required");

        if ( email.isEmpty() ) {
            registration.recordError(emailField, "Email is required");
        } else if ( !Util.isValidEmail(email) ){
            registration.recordError(emailField, "invalid email address");
        }

        if ( password.isEmpty() ) {
            registration.recordError(passwordField, "Password is required");
        } else if ( password.length() < 6 ){
            registration.recordError(passwordField, "Please insert more than 6 char");
        }
    }

    Object onSuccessFromRegistration() {
        logger.info("Login successful!");
        alertManager.success("Welcome aboard!");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(Util.md5(password));

        userService.addUser(user);
        return Login.class;
    }

    void onFailureFromRegistration() {
        logger.warn("Login error!");
        alertManager.error("I'm sorry but I can't log you in!");
    }


}
