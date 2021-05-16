package com.github.controllers;


import com.github.dto.UserRegistrationDto;
import com.github.exceptions.CryptoException;
import com.github.service.UsersService;
import com.github.dto.UserAuthorizationDto;
import com.github.entity.User;
import com.github.payload.Token;
import com.github.utils.TokenProvider;
import com.github.utils.TransferObject;

import java.util.Objects;

public class UserControllers {

    private final UsersService usersService;

    public UserControllers(UsersService customUsersService) {

        this.usersService = customUsersService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.usersService.findByNickname(TransferObject.toUser(payload));
        if (!Objects.isNull(user)) {
            int LIFETIME = 1800000;
            Token token = new Token(
                    user.getId(),
                    user.getRole(),
                    user.getNickname(),
                    System.currentTimeMillis(),
                    System.currentTimeMillis() + LIFETIME
            );
            return TokenProvider.encode(token);
        } else {
            return null;
        }
    }

    public boolean reg(UserRegistrationDto payload) {
        User user = TransferObject.toUser(payload);
        if (Objects.isNull(this.usersService.findByNickname(user)) &&
                Objects.isNull(this.usersService.findByEmail(user))) {
            this.usersService.create(user);
            return true;
        } else {
            return false;
        }
    }
}
