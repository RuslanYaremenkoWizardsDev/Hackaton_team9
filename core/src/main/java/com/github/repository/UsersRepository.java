package com.github.repository;


import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;

public class UsersRepository {

    private final CustomJdbcTemplate jdbcTemplate;

    public UsersRepository(CustomJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByAuthDto(UserAuthorizationDto userAuthorizationDto){
        return jdbcTemplate.findBy(
                "SELECT * FROM users WHERE login = ? AND password = ?",
                RowMappers.getCustomRowMapperUser(),
                userAuthorizationDto.getLogin(),
                userAuthorizationDto.getPassword()
        );
    }

    public User findById(long id){
        return jdbcTemplate.findBy(
                "SELECT * FROM users WHERE id = ?",
                RowMappers.getCustomRowMapperUser(),
                id
        );
    }

    public User insert(UserRegistrationDto userRegistrationDto){
        System.out.println("INSERT");
        return jdbcTemplate.insert(
                "INSERT INTO users (first_name, last_name, email, login, password, phone_number) VALUES(?, ?, ?, ?, ?, ?)",
                RowMappers.getCustomRowMapperUser(),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getLogin(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getPhone()
        );
    }

    public void delete(UserRegistrationDto userRegistrationDto){
        jdbcTemplate.delete(
                "DELETE FROM users WHERE login = ?",
                userRegistrationDto.getLogin()
        );
    }

    public void update(UserRegistrationDto userRegistrationDto){
        jdbcTemplate.update(
                "UPDATE users " +
                        "SET first_name = ?, last_name = ?, email = ?, login = ?, password = ?, phone_number = ?" +
                        "WHERE login = ?",
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getLogin(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getPhone(),
                userRegistrationDto.getLogin()
                );
    }

}
