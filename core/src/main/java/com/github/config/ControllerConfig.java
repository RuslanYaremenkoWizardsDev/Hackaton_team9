package com.github.config;

import com.github.controllers.UserControllers;

public class ControllerConfig {

    public static UserControllers usersController(){
        return new UserControllers(DatabaseConfig.getUsersService());
    }

}
