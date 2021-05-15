package com.github.service;


import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import com.github.repository.UsersRepository;

public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User findById(long id) {
        return this.usersRepository.findById(id);
    }

    public User findByAuth(UserAuthorizationDto auth) {
        return this.usersRepository.findByAuthDto(auth);
    }

    public User insert(UserRegistrationDto userRegistrationDto) {
        return this.usersRepository.insert(userRegistrationDto);
    }

    public void delete(UserRegistrationDto userRegistrationDto) {
        this.usersRepository.delete(userRegistrationDto);
    }

    public void update(UserRegistrationDto userRegistrationDto) {
        this.usersRepository.update(userRegistrationDto);
    }
}
