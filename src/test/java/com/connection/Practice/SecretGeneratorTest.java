package com.connection.Practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.connection.otp.service.impl.SecretGenerator;

 class SecretGeneratorTest {

    @Test
     void testSecretGenerated() {
        SecretGenerator generator = new SecretGenerator();
        String secret = generator.generate();
        assertNotNull(secret);
        assertTrue(secret.length() > 0);
    }

    @Test
     void testCharacterLengths() {
        for (int charCount : new int[]{16, 32, 64, 128}) {
            SecretGenerator generator = new SecretGenerator(charCount);
            String secret = generator.generate();
            assertEquals(charCount, secret.length());
        }
    }

    @Test
     void testValidBase32Encoded() {
        SecretGenerator generator = new SecretGenerator();
        String secret = generator.generate();

        // Test the string contains only A-Z, 2-7 with optional ending =s
        assertTrue(secret.matches("^[A-Z2-7]+=*$"));

        // And the length must be a multiple of 8
        assertEquals(0, secret.length() % 8);
    }
}
