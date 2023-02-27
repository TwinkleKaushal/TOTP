package com.connection.otp.advise;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.connection.otp.exception.MyError;
import com.connection.otp.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MyError> GlobalException(ResourceNotFoundException res,WebRequest req , Exception e){
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		String stackTrace = stringWriter.toString();
		MyError er= new MyError(Instant.now().getEpochSecond(),"404","1",
				res.getMessage(),Instant.now().getEpochSecond(),stackTrace,"api/v2.1.0/org/ValidateOTP");
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);

	}
}