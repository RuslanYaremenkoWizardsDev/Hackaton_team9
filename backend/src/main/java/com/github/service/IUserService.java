package com.github.service;

import com.github.dto.UserRegistrationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.entity.User;

public interface IUserService {

    User findById(long id);

    User findByAuth(UserAuthorizationDto auth);

    User insert(UserRegistrationDto userRegistrationDto);

    void delete(UserRegistrationDto userRegistrationDto);

    User update(UserRegistrationDto userRegistrationDto);

}
