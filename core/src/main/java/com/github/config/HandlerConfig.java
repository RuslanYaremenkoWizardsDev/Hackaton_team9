package com.github.config;

import com.github.handler.UsersHandlers;

public class HandlerConfig {
    public static UsersHandlers usersHandlers() {
        return new UsersHandlers(ControllerConfig.usersController());
    }
}
