package com.github.utils;

import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonHelperTest {
    private String str1 = "Test-1";

    private Integer int1 = 9888;

    private User user = new User();

    private UserAuthorizationDto userAuthorizationDto = new UserAuthorizationDto("login", "password");

    private UserRegistrationDto userRegistrationDto = new UserRegistrationDto("Danylo","password");

    @Test
    public void toFormatOutFormatEqualityString() {
        String str = JsonHelper.toFormat(str1).get();
        Assert.assertEquals(str1,JsonHelper.fromFormat(str,String.class).get());
    }

    @Test
    public void toFormatOutFormatEqualityInteger() {
        String str = JsonHelper.toFormat(int1).get();
        Assert.assertEquals(int1,JsonHelper.fromFormat(str,Integer.class).get());
    }

    @Test
    public void toFormatOutFormatEqualityUser() {
        String str = JsonHelper.toFormat(user).get();
        Assert.assertEquals(user,JsonHelper.fromFormat(str,User.class).get());
    }

    @Test
    public void toFormatOutFormatEqualityUserAuthDto() {
        String str = JsonHelper.toFormat(userAuthorizationDto).get();
        Assert.assertEquals(userAuthorizationDto,JsonHelper.fromFormat(str,UserAuthorizationDto.class).get());
    }

    @Test
    public void toFormatOutFormatEqualityUserRegDto() {
        String str = JsonHelper.toFormat(userRegistrationDto).get();
        Assert.assertEquals(userRegistrationDto,JsonHelper.fromFormat(str,UserRegistrationDto.class).get());
    }


}