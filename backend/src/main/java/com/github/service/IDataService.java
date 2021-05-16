package com.github.service;

import com.github.dto.UserRegistrationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.entity.User;

import java.util.List;

public interface IDataService {

    User create(User user);

    List<User> read();

    User findByNickname(User user);

    User findByEmail(User user);

    void update(User user);

    void delete(User user);

}
