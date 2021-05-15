package com.github.repository;

import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;

import java.util.Collection;

public interface UserRepository<T> {

    Collection<T> findAll();

    User findAuth(UserAuthorizationDto userAuthorizationDto);

    User findReg(UserRegistrationDto userRegistrationDto);

    User insert(UserRegistrationDto userRegistrationDto);

    User update(User user);

    void delete(User user);

    void deleteAll();
}
