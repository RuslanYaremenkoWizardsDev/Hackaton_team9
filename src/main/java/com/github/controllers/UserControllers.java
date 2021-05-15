package com.github.controllers;


import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import com.github.exceptions.UserAlreadyExistException;
import com.github.payload.Token;
import com.github.service.UsersService;
import com.github.utils.TokenProvider;

public class UserControllers {

    private final UsersService usersService;

    public UserControllers(UsersService customUsersService) {
        this.usersService = customUsersService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.usersService.findByAuth(payload);
        return TokenProvider.encode(new Token(user));
    }

    public void registration(UserRegistrationDto userRegistrationDto) {
        //User u = TransferObj.toUser(payload);
        if (this.usersService.findByAuth(new UserAuthorizationDto(userRegistrationDto)) != null) {
            throw new UserAlreadyExistException();
        }
        //customUsersService.insert(u);
        usersService.insert(userRegistrationDto);
    }
}
