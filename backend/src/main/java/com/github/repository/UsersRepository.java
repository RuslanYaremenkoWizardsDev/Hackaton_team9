package com.github.repository;

import com.github.dto.UserAuthorizationDto;
import com.github.dto.UserRegistrationDto;
import com.github.entity.User;
import com.github.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersRepository {

    public void saveStudent(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository();
        usersRepository.saveStudent(new User());
    }

    public User findByAuthDto(UserAuthorizationDto userAuthorizationDto){
//        return jdbcTemplate.findBy(
//                "SELECT * FROM users WHERE login = ? AND password = ?",
//                RowMappers.getCustomRowMapperUser(),
//                userAuthorizationDto.getLogin(),
//                userAuthorizationDto.getPassword()
//        );
        return null;
    }

    public User findById(long id){
//        return jdbcTemplate.findBy(
//                "SELECT * FROM users WHERE id = ?",
//                RowMappers.getCustomRowMapperUser(),
//                id
//        );
        return null;
    }

    public User insert(UserRegistrationDto userRegistrationDto){
        System.out.println("INSERT");
//        return jdbcTemplate.insert(
//                "INSERT INTO users (first_name, last_name, email, login, password, phone_number) VALUES(?, ?, ?, ?, ?, ?)",
//                RowMappers.getCustomRowMapperUser(),
//                userRegistrationDto.getFirstName(),
//                userRegistrationDto.getLastName(),
//                userRegistrationDto.getEmail(),
//                userRegistrationDto.getLogin(),
//                userRegistrationDto.getPassword(),
//                userRegistrationDto.getPhone()
//        );
        return null;
    }

    public void delete(UserRegistrationDto userRegistrationDto){
//        jdbcTemplate.delete(
//                "DELETE FROM users WHERE login = ?",
//                userRegistrationDto.getLogin()
//        );
        return;
    }

    public void update(UserRegistrationDto userRegistrationDto){
//        jdbcTemplate.update(
//                "UPDATE users " +
//                        "SET first_name = ?, last_name = ?, email = ?, login = ?, password = ?, phone_number = ?" +
//                        "WHERE login = ?",
//                userRegistrationDto.getFirstName(),
//                userRegistrationDto.getLastName(),
//                userRegistrationDto.getEmail(),
//                userRegistrationDto.getLogin(),
//                userRegistrationDto.getPassword(),
//                userRegistrationDto.getPhone(),
//                userRegistrationDto.getLogin()
//                );
    }

}
