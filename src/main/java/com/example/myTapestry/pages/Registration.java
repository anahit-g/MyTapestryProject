package com.example.myTapestry.pages;

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

        if (!name.equals("users@tapestry.apache.org"))
            registration.recordError(nameField, "Try with user: users@tapestry.apache.org");

        if (!surname.equals("Tapestry5"))
            registration.recordError(surnameField, "Try with user: users@tapestry.apache.org");

        if (!email.equals("users@tapestry.apache.org"))
            registration.recordError(emailField, "Try with user: users@tapestry.apache.org");

        if (!password.equals("Tapestry5"))
            registration.recordError(passwordField, "Try with password: Tapestry5");
    }

    Object onSuccessFromLogin() {
        logger.info("Login successful!");
        alertManager.success("Welcome aboard!");

        return Index.class;
    }

    void onFailureFromRegistration() {
        logger.warn("Login error!");
        alertManager.error("I'm sorry but I can't log you in!");
    }
}
