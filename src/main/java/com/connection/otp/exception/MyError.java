package com.connection.otp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyError {
	
	long timestamp;
	String statusCode;
	String errorCode;
	String message;
	long traceId;
	String trace;
	String path;

}
