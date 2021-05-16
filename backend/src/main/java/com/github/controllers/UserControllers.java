package com.github.controllers;


import com.github.dto.TournamentCreationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.Tournament;
import com.github.entity.User;
import com.github.payload.Token;
import com.github.service.UsersService;
import com.github.utils.TokenProvider;
import com.github.utils.TransferObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class UserControllers {

    private static final Logger logger = LoggerFactory.getLogger(UserControllers.class);

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
        User user;
        try {
            user = TransferObject.toUser(payload);
        } catch (IllegalArgumentException e){
            logger.warn(e.getMessage());
            return false;
        }
        if (Objects.isNull(this.usersService.findByNickname(user)) &&
                Objects.isNull(this.usersService.findByEmail(user))) {
            this.usersService.create(user);
            return true;
        } else {
            return false;
        }
    }

    public User findUser(String nickname) {
        User user = TransferObject.toUser(nickname);
        return this.usersService.findByNickname(user);
    }

    public boolean createTournament(TournamentCreationDto tournamentCreationDto){
        Tournament tournament = TransferObject.toTournament(tournamentCreationDto);
        if (Objects.nonNull(tournament)){
            this.usersService.createTournament(tournament);
            return true;
        } else {
            return false;
        }
    }
}
