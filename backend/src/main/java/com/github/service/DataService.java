package com.github.service;

import com.github.controllers.UserControllers;
import com.github.entity.Tournament;
import com.github.entity.User;
import com.github.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class DataService implements IDataService {

    private static final Logger log = LoggerFactory.getLogger(UserControllers.class);

    private final Repository repository;

    public DataService(Repository repository) {

        this.repository = repository;
    }

    @Override
    public User create(User user) {
         return this.repository.save(user);
    }

    @Override
    public List<User> read() {
        return this.repository.findAll();
    }

    @Override
    public User findByEmail(User user) {

        return this.repository.findByEmail(user);
    }


    @Override
    public User findByNickname(User user) {
        return this.repository.findByNickname(user);
    }

    @Override
    public void update(User user) {

        this.repository.update(user);
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

    public Tournament createTournament(Tournament tournament) {
        return this.repository.save(tournament);
    }


}