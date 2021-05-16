package com.github.service;

import com.github.controllers.UserControllers;
import com.github.entity.User;
import com.github.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class UsersService implements IUserService{

    private static final Logger log = LoggerFactory.getLogger(UserControllers.class);

    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {

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


}