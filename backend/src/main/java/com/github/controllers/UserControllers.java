package com.github.controllers;


import com.github.dto.UserRegistrationDto;
import com.github.service.UsersService;
import com.github.dto.UserAuthorizationDto;
import com.github.entity.User;
import com.github.exceptions.CryptoException;
import com.github.exceptions.UserAlreadyExistException;
import com.github.payload.Token;
import com.github.utils.TokenProvider;

public class UserControllers {

    private final UsersService usersService;

    public UserControllers(UsersService customUsersService) {
        this.usersService = customUsersService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.usersService.findByAuth(payload);
        try {
            return TokenProvider.encode(new Token(user));
        } catch (CryptoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registration(UserRegistrationDto userRegistrationDto) {
        if (this.usersService.findByAuth(new UserAuthorizationDto(userRegistrationDto)) != null) {
            throw new UserAlreadyExistException();
        }
        usersService.insert(userRegistrationDto);
    }
}
