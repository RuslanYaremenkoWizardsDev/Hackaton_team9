package com.github.config;

import com.github.repository.UsersRepository;
import com.github.service.UsersService;

public class DatabaseConfig {

    public static UsersService getUsersService() {
        return new UsersService(new UsersRepository());
    }

}
