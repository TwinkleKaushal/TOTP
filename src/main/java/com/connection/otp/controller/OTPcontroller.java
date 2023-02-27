package com.connection.otp.controller;

import java.time.Instant;
import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connection.otp.exception.CodeGenerationException;
import com.connection.otp.model.OtpModel;
import com.connection.otp.model.common.EmailSenderModel;
import com.connection.otp.model.common.SendSmsModel;
import com.connection.otp.model.common.TwilioModel;
import com.connection.otp.model.common.ValidateOtpModel;
import com.connection.otp.service.impl.CodeGenerator;
import com.connection.otp.service.impl.EmailSenderService;
import com.connection.otp.service.impl.SecretGenerator;
import com.connection.otp.service.impl.TimeProvider;
import com.connection.otp.service.impl.TwilioOTPservice;

@RestController
public class OTPcontroller {

	@Autowired
	private CodeGenerator otp;

	@Autowired
	private SecretGenerator secretkey;

	@Autowired
	private TimeProvider systemTime;

	@Autowired
	private SecretGenerator secret;

	@Autowired
	TwilioOTPservice twilioservice;

	@Autowired
	EmailSenderService emailsenderservice;

	String generatedOtp = "";

	@PostMapping("api/v2.1.0/org/GenerateOTP")
	public OtpModel generateCode(@RequestBody SendSmsModel sms) throws CodeGenerationException, MessagingException {
		generatedOtp = otp.generate(secretkey.generate(), systemTime.getTime());

		TwilioModel twiliodto = new TwilioModel(sms.getMobileNo(), generatedOtp);
		twilioservice.sendOTPtoNum(twiliodto);

		EmailSenderModel emailsenderdto = new EmailSenderModel(sms.getEmail(),
				"Dear Customer , Your OTP is ##" + generatedOtp + "##. Thank You!!.", "Verification OTP");
		emailsenderservice.sendOTPtoEmail(emailsenderdto);

		OtpModel generate = new OtpModel(sms.getEmail(), Instant.now().getEpochSecond(), "200",
				"OTP generated successfully", secret.generate(), generatedOtp);
		return generate;

	}

	@PostMapping("api/v2.1.0/org/ValidateOTP/{totp}")
	public ValidateOtpModel verifyOTP(@PathVariable @Valid String totp) throws Exception {

		if (generatedOtp.equals(totp)) {
			ValidateOtpModel validate = new ValidateOtpModel(totp, "200", "Validated successfully!");
			return validate;
		} else {
			throw new com.connection.otp.exception.ResourceNotFoundException("Please enter valid OTP");
		}
	}
}
