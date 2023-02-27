package com.connection.Practice;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;


import org.junit.jupiter.api.Test;

import com.connection.otp.enumuration.HashingAlgorithm;
import com.connection.otp.exception.CodeGenerationException;
import com.connection.otp.service.impl.CodeGenerator;

 class CodeGeneratorTest {

  

    @Test
     void testInvalidHashingAlgorithmThrowsException() {
        assertThrows(InvalidParameterException.class, () -> {
            new CodeGenerator(null, 6);
        });
    }
    
    @Test
     void testInvalidDigitLengthThrowsException() {
        assertThrows(InvalidParameterException.class, () -> {
            new CodeGenerator(HashingAlgorithm.SHA1, 0);
        });
    }

    @Test
     void testInvalidKeyThrowsCodeGenerationException() throws CodeGenerationException {
        CodeGenerationException e = assertThrows(CodeGenerationException.class, () -> {
            CodeGenerator g = new CodeGenerator(HashingAlgorithm.SHA1, 4);
            g.generate("1234", 1567631536);
        });
        assertNotNull(e.getCause());
    }

}
