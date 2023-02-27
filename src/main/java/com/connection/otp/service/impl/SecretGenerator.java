package com.connection.otp.service.impl;

import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base32;
import org.springframework.stereotype.Service;

import com.connection.otp.service.ISecretGenerator;

@Service
public class SecretGenerator implements ISecretGenerator {

    private final SecureRandom randomBytes = new SecureRandom();
    private final Base32 encoder = new Base32();
    private final int numCharacters;

    public SecretGenerator() {
        this.numCharacters = 32;
    }

    /**
     * @param numCharacters The number of characters the secret should consist of.
     */
    public SecretGenerator(int numCharacters) {
        this.numCharacters = numCharacters;
    }

    @Override
    public String generate() {

        return new String(encoder.encode(getRandomBytes()));
    }

    private byte[] getRandomBytes() {
        // 5 bits per char in base32(Encoding-decoding technique)
        byte[] bytes = new byte[(numCharacters * 5) / 8];
        randomBytes.nextBytes(bytes);
        
        return bytes;
    }
}

