package com.github.utils;

import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;

import java.util.regex.Pattern;

public class TransferObject {

    public static User toUser(UserRegistrationDto payload) {
        User user = null;
        if (payload.getPassword().equals(payload.getConfirmPassword())){
            if (checkLogin(payload.getLogin())){
                String nickname = payload.getLogin();
                user = new User(nickname, payload.getLogin(),payload.getPassword());
            } else {
                user = new User (payload.getLogin(), payload.getPassword());
            }
        }
        return user;
    }

    public static User toUser(UserAuthorizationDto payload) {
        User user = null;
        if (checkLogin(payload.getLogin())){
            String nickname = payload.getLogin();
            user = new User(nickname, payload.getLogin(),payload.getPassword());
        } else {
            user = new User (payload.getLogin(), payload.getPassword());
        }
        return user;
    }

    public static boolean checkLogin (String login){
        return Pattern.compile(".@.$").matcher(login).matches();
    }
}
