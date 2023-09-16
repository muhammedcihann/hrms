package com.example.hrms.core.utilities.verifications;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailVerifyManager implements EmailVerifyService{
	
	
	@SuppressWarnings("unused")
	private Map<String, String> verificationCodes = new HashMap<>(); 
	
	@Override
	public Result verify(String email) {
		
	
	@SuppressWarnings("unused")
	String verificationCode = generateVerificationCode();
		
		
		return new SuccessResult("Email adresinizi onaylamanız için kod gönderildi: " + email);
		
	}

	@Override
	public Result checkVerificationCode(String email, String userEnteredCode) {
		
	    String emailVerificationCode = ""; // Doğrulama kodlarını sakladığınız veritabanı veya cache'den alın

	    if (userEnteredCode.equals(emailVerificationCode)) {
	    	
	        return new SuccessResult("E-posta doğrulama başarılı.");
	        
	    } 
	    else {
	    	
	        return new ErrorResult("E-posta doğrulama kodu yanlış.");
	    }
	}

	public String generateVerificationCode() {
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}
