package com.github.config;

import com.github.handler.Handler;

public class HandlerConfig {
    public static Handler usersHandlers() {
        return new Handler(ControllerConfig.usersController());
    }
}
