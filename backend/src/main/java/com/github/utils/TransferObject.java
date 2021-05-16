package com.github.utils;

import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;

import java.util.regex.Pattern;

public class TransferObject {

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
        }
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
        Pattern pattern = Pattern.compile("[\\w\\d]{6,20}");
        return user.getNickname().matches("[A-Za-z0-9]{6,20}") && user.getPassword().matches("[\\w\\d\\@\\!\\#\\$\\%\\^\\&\\*\\)\\(\\`\\'\"\\:\\;\\{\\}]{6,20}");
    }
}
