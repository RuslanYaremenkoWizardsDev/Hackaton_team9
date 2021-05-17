package com.github.utils;

import com.github.exceptions.BadRequest;
import com.github.payload.Token;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TokenProviderTest {
    Token t = new Token(1L, "USER", "Oneone", System.currentTimeMillis(), System.currentTimeMillis()+1800000);
    Token tAnother = new Token(203L, "ADMIN","Admin1234", System.currentTimeMillis(), System.currentTimeMillis()+1800000);
    Token tNull = null;

    @Test
    public void encode (){
        String cipher = TokenProvider.encode(t);
        Token token = TokenProvider.decode(cipher);
        Assert.assertEquals(t,token);
    }

    @Test
    public void encodeAnother (){
        String cipher = TokenProvider.encode(tAnother);
        Token token = TokenProvider.decode(cipher);
        Assert.assertEquals(tAnother,token);
    }

    @Test (expected = BadRequest.class)
    public void encodeNull (){
        String cipher = TokenProvider.encode(tNull);
        Token token = TokenProvider.decode(cipher);
    }
}