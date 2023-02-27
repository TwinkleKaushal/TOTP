package com.connection.otp.service;

public interface ISecretGenerator {
    /**
     * @return A random base32 encoded string to use as the shared secret/key between the server and the client.
     */
    String generate();
}
