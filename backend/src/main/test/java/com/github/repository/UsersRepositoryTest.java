package com.github.repository;

import com.github.config.DatabaseConfig;
import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import com.github.service.UsersService;
import org.junit.Assert;
import org.junit.Test;

public class UsersRepositoryTest {
    private UsersService repo = DatabaseConfig.getUsersService();

    private UserRegistrationDto userRegistrationDto = new UserRegistrationDto("login","password");
    private UserAuthorizationDto userAuthorizationDto = new UserAuthorizationDto("login","password");
    private User user1 = new User("nickname","password");
    private User user = new User("nickname","password");
    private UserRegistrationDto userRegistrationDto1 = new UserRegistrationDto(user);

    @Test
    public void findByAuthDto() {
        repo.findByNickname(user);
        Assert.assertEquals(new UserRegistrationDto(user), new UserRegistrationDto(repo.findByNickname(user)));
        repo.delete(user);
    }

    @Test
    public void insertAndDelete() {
        repo.findByNickname(user);
        repo.delete(user);
        Assert.assertEquals(null, repo.findByNickname(user));
    }


}