package com.github.payload;

import com.github.entity.Role;
import com.github.entity.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Token implements Serializable {

    private static final int HALF_HOUR = 1800000;

    private Long id;

    private Role role;

    private String nickname;

    private long expireIn;

    private long createdAt;

    public Token() {
    }

    public Token(Long id, Role role, String nickname, long currentTimeMillis, long l) {
        this.id = id;
        this.role = role;
        this.nickname = nickname;
        this.createdAt = currentTimeMillis;
        this.expireIn = l;
    }

    public void setExpireIn(Date expireIn) {
        this.expireIn = expireIn.getTime();
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt.getTime();
    }

    public Token(User user, Date createdAt) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.createdAt = createdAt.getTime();
        this.expireIn = this.createdAt + HALF_HOUR;
    }

    public Token(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.createdAt = System.currentTimeMillis();
        this.expireIn = System.currentTimeMillis() + HALF_HOUR;
    }

    public Role getRole() {
        return role;
    }

    public String getNickname() {
        return nickname;
    }

    public long getExpireIn() {
        return expireIn;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return expireIn == token.expireIn &&
                createdAt == token.createdAt &&
                role == token.role &&
                Objects.equals(nickname, token.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, nickname, expireIn, createdAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "role=" + role +
                ", nickname='" + nickname + '\'' +
                ", expireIn=" + expireIn +
                ", createdAt=" + createdAt +
                '}';
    }
}
