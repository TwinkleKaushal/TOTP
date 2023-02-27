package com.connection.Practice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.connection.otp.service.impl.SecretGenerator;

@SpringBootTest
class OtpApplicationTests {

	@Test
	void contextLoads() {
		SecretGenerator generator = new SecretGenerator();
        String secret = generator.generate();
        assertNotNull(secret);
        assertTrue(secret.length() > 0);
		
		
	}

}
