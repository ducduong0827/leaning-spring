package com.me.springsecurity;

import org.junit.jupiter.api.Test;
import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.SecretKey;

public class JwtSecretMakerTest {
    @Test
    public void generateSecretKey() {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf(encodedKey);
    }
}
