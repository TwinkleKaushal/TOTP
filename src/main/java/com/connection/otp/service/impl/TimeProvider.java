package com.connection.otp.service.impl;

import java.time.Instant;
import org.springframework.stereotype.Service;

import com.connection.otp.exception.TimeProviderException;
import com.connection.otp.service.ITimeProvider;

@Service
public class TimeProvider implements ITimeProvider {
    @Override
    public long getTime() throws TimeProviderException {
        return Instant.now().getEpochSecond();
    }
}

