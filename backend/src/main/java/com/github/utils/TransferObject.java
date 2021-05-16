package com.github.utils;

import com.github.dto.TournamentCreationDto;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.Tournament;
import com.github.entity.User;

import java.util.regex.Pattern;

public class TransferObject {

    public static Tournament toTournament(TournamentCreationDto tournamentCreationDto) {
        Tournament tournament = new Tournament(
                tournamentCreationDto.getTourName(),
                tournamentCreationDto.getDescription(),
                tournamentCreationDto.getMode(),
                tournamentCreationDto.getPlace(),
                tournamentCreationDto.getStartDate(),
                tournamentCreationDto.getLastRegistration(),
                tournamentCreationDto.getTourLvl(),
                tournamentCreationDto.getPlayerQuantity(),
                tournamentCreationDto.getScenario(),
                tournamentCreationDto.getPlayers(),
                tournamentCreationDto.getStatus()
        );
        return tournament;
    }

    public static User toUser(String nickname) {
        User user = new User();
        user.setNickname(nickname);
        return user;
    }

    public static User toUser(UserRegistrationDto payload) {
        User user = null;
        if (payload.getPassword().equals(payload.getConfirmPassword())){
            if (isEmailString(payload.getLogin())){
                String nickname = payload.getLogin();
                user = new User(nickname, payload.getLogin(),payload.getPassword());
            } else {
                user = new User (payload.getLogin(), payload.getPassword());
                if(!isLegalUser(user)) throw new IllegalArgumentException("Illegal user");
            }
        } else throw new IllegalArgumentException("Password is not confirmed");
        return user;
    }

    public static User toUser(UserAuthorizationDto payload) {
        User user = null;
        if (isEmailString(payload.getLogin())){
            String nickname = payload.getLogin();
            user = new User(nickname, payload.getLogin(),payload.getPassword());
        } else {
            user = new User (payload.getLogin(), payload.getPassword());
        }
        return user;
    }

    private static boolean isEmailString(String login){
        return Pattern.compile(".*@.*\\..*$").matcher(login).matches();
    }

    private static boolean isLegalUser(User user) {
        return user.getNickname().matches("[\\w\\d]{6,20}") && user.getPassword().matches("[\\w\\d\\@\\!\\#\\$\\%\\^\\&\\*\\)\\(\\`\\'\"\\:\\;\\{\\}]{6,20}");
    }
}
