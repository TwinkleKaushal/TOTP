package com.connection.otp.service;

import org.springframework.cglib.core.CodeGenerationException;

public interface ICodeGenerator {
    /**
     * @param secret The shared secret/key to generate the code with.
     * @param counter The current time bucket number. Number of seconds since epoch / bucket period.
     * @return The n-digit code for the secret/counter.
    * @throws CodeGenerationException Thrown if the code generation fails for any reason
     
     */
    String generate(String secret, long counter) throws CodeGenerationException, com.connection.otp.exception.CodeGenerationException;
}
