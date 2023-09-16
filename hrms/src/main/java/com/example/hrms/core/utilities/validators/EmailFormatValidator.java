package com.example.hrms.core.utilities.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component // ??
public class EmailFormatValidator {

	public boolean checkEmailFormat(String email, String website) {
		int wwwIndex = website.indexOf("www."); // indexof kaçıncı noktada olduğunu bulmamızı sağlayacak burda
		String domain = (wwwIndex != -1) ? website.substring(wwwIndex + 4) : website;

		String emailRegex = "^([A-Za-z0-9*-_])+(@(" + domain + "){1})$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {

			return true;
		}

		else {

			return false;
		}
	}
}
