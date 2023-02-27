package com.connection.otp.service;

import com.connection.otp.exception.TimeProviderException;

public interface ITimeProvider {
    /**
     * @return The number of seconds since Jan 1st 1970, 00:00:00 UTC.
     */
    long getTime() throws TimeProviderException;
}