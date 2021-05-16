package com.github.controllers;


import com.github.dto.TournamentCreationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.Tournament;
import com.github.entity.User;
import com.github.payload.Token;
import com.github.service.DataService;
import com.github.utils.TokenProvider;
import com.github.utils.TransferObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class UserControllers {

    private static final Logger logger = LoggerFactory.getLogger(UserControllers.class);

    private final DataService dataService;

    public UserControllers(DataService customDataService) {
        this.dataService = customDataService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.dataService.findByNickname(TransferObject.toUser(payload));
        if (!Objects.isNull(user)) {
            Token token = new Token(user);
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
        if (Objects.isNull(this.dataService.findByNickname(user)) &&
                Objects.isNull(this.dataService.findByEmail(user))) {
            this.dataService.create(user);
            return true;
        } else {
            return false;
        }
    }

    public User findUser(String nickname) {
        User user = TransferObject.toUser(nickname);
        return this.dataService.findByNickname(user);
    }

    public boolean createTournament(TournamentCreationDto tournamentCreationDto){
        Tournament tournament = TransferObject.toTournament(tournamentCreationDto);
        if (Objects.nonNull(tournament) && Objects.isNull(this.dataService.findByName(tournament))){
            this.dataService.createTournament(tournament);
            return true;
        } else {
            return false;
        }
    }

    public List<Tournament> getAllTournaments() {
        return this.dataService.readAllTournaments();
    }
}
