package com.github.entity;

import org.junit.Test;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class UserTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "age")
    private int age;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "secretKey")
    private String secretKey;

    @Column(name = "role")
    private Role role;

    public void UserTest() {
    }
    @Test
    public void UserTest(Long id, String nickname, String email, String password, String city, int age, String hobby, String avatar, String secretKey, Role role) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.city=city;
        this.age=age;
        this.hobby=hobby;
        this.avatar=avatar;
        this.secretKey=secretKey;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getnickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getCity(){
        return city;
    }

    public int getAge(){
        return age;
    }

    public String getHobby(){
        return hobby;
    }

    public String getAvatar(){
        return avatar;
    }

    public String getSecretKey(){
        return secretKey;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.getId()) && Objects.equals(nickname, user.getNickname()) && Objects.equals(email, user.getEmail()) && Objects.equals(password, user.getPassword())&& Objects.equals(city, user.getCity())&& Objects.equals(age, user.getAge())&& Objects.equals(hobby, user.getHobby())&& Objects.equals(avatar, user.getAvatar()) && Objects.equals(secretKey, user.getSecretKey())   && Objects.equals(role, user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, email, password,city,age,hobby,avatar,secretKey, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", hobby='" + hobby + '\'' +
                ", avatar='" + avatar + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", role=" + role +
                '}';
    }
}