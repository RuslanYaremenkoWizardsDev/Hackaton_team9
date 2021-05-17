package com.github.config;

import com.github.repository.Repository;
import com.github.service.DataService;

public class DatabaseConfig {

    public static DataService getUsersService() {
        return new DataService(new Repository());
    }

}
