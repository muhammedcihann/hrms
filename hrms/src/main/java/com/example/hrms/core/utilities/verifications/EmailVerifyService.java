package com.example.hrms.core.utilities.verifications;

import com.example.hrms.core.utilities.results.Result;

public interface EmailVerifyService {
	Result verify(String email);
	
	Result checkVerificationCode(String email, String userEnteredCode);
	
	String generateVerificationCode();
}
