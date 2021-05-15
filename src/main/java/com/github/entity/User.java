package com.github.entity;

import java.util.Objects;

public class User {

    private Long id;

    private Role role;

    private String nickname;

    private String email;

    private String password;

    private String city;

    private int age;

    private String hobby;

    private String avatar;

    private String secretKey;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                role == user.role &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(city, user.city) &&
                Objects.equals(hobby, user.hobby) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(secretKey, user.secretKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, nickname, email, password, city, age, hobby, avatar, secretKey);
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", avatar='" + avatar + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
