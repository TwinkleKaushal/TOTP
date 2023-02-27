package com.connection.otp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connection.otp.configuration.EmailModel;
import com.connection.otp.exception.TimeProviderException;
import com.connection.otp.model.common.TwilioModel;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioOTPservice {
    
	@Autowired
	private EmailModel twilioconfig;
	
	public Message sendOTPtoNum(TwilioModel twilioModel) throws TimeProviderException {

            PhoneNumber to = new PhoneNumber(twilioModel.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioconfig.getTrial_number());
            String otpMessage = "Dear Customer , Your OTP is ##" + "Happy Birthday"+ "##. Thank You!!.";
            Message message = Message
            		.creator(to, from,
                            otpMessage)
					.create();
			return message;
	}
}
